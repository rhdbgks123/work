import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

createApp(App).use(router).use(store).mount("#app");
window.Kakao.init("b6b345ce6198725f676ab74da5444220");
