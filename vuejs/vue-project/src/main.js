import { createApp } from 'vue'
import App from './App.vue'
import router from './router'// url과 컴포넌트 연결

createApp(App).use(router).mount('#app')
