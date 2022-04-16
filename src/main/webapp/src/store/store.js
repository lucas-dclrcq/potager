import { reactive } from 'vue'

export const store = reactive({
    token: null,
    setToken(token) {
        this.token = token;
    },
})