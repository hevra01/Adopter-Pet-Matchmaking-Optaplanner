import {createApp} from "vue";
import App from "./App.vue";
import router from "./router";
import axios from "axios";
import store from "@/store";

axios.defaults.headers.common["Authorization"] = `Bearer ${store.state.token}`;

createApp(App).use(router).use(store).mount("#app");
