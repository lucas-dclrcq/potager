import 'bulma/css/bulma.css'

import {createApp} from "vue";
import App from "./App.vue";
import router from "./router";

const createMyApp = () => {
  const app = createApp(App);
  app.use(router);
  app.mount("#app");
};

createMyApp();