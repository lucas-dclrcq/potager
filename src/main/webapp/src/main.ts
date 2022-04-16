import 'bulma/css/bulma.css'

import {createApp} from "vue";
import App from "./App.vue";
import router from "./router";
import VueKeyCloak from '@dsb-norge/vue-keycloak-js'
import type {VueKeycloakInstance} from "@dsb-norge/vue-keycloak-js/dist/types";
import axios from "axios";

let initOptions = {
    url: import.meta.env.VITE_APP_KEYCLOAK_URL,
    realm: import.meta.env.VITE_APP_KEYCLOAK_REALM,
    clientId: import.meta.env.VITE_APP_KEYCLOAK_CLIENT_ID,
    onLoad: 'login-required',
    checkLoginIframe: false
}

function configureTokenInterceptor(keycloak: any) {
    axios.interceptors.request.use(config => {
        if (keycloak.authenticated) {
            // @ts-ignore
            config.headers.Authorization = `Bearer ${keycloak.token}`
        }
        return config
    }, (error: any) => {
        return Promise.reject(error)
    })
}

const app = createApp(App);

app
    .use(VueKeyCloak, {
        config: initOptions,
        init: {onLoad: 'login-required'},
        onReady(keycloak: any) {
            console.log('Keycloak Ready', keycloak);
            configureTokenInterceptor(keycloak);
            app.use(router)
                .mount("#app");
        },
    });

declare module '@vue/runtime-core' {
    interface ComponentCustomProperties {
        $keycloak: VueKeycloakInstance
    }
}