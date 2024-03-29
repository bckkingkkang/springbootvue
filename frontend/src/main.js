import {createApp} from 'vue'

import '@/assets/css/style.css'

import App from '@/App.vue'
import router from '@/router'
import axios from 'axios'
import store from "@/vuex/store.js";
// import {BootstrapVue3} from "bootstrap-vue-3";
// import 'bootstrap/dist/css/bootstrap.css'
// import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'



const app = createApp(App);

// 전역 변수 설정
app.config.globalProperties.$axios = axios;
app.config.globalProperties.$serverUrl = '//localhost:8080'
app.config.globalProperties.$server = store

// app.use(BootstrapVue3)
app.use(router)
app.use(store)
app.mount('#app')
