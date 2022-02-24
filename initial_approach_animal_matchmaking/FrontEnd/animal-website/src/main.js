import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import axios from "axios"
import {createStore} from "vuex";

const store = createStore({
    state() {
        return {
            count: 0
        }
    },
    mutations: {
        increment(state) {
            state.count++
        }
    },
})
createApp(App).use(router, axios, store).mount('#app')
