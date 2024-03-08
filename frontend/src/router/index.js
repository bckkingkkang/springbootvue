import { createRouter, createWebHistory } from 'vue-router'
import Home from "@components/Home.vue";
import Login from "@components/Login.vue";
import List from "@components/board/List.vue";
import Write from "@components/board/Write.vue";
import Detail from "@components/board/Detail.vue";


const routes = [
    {path:'/', name:'Home', component:Home},
    {path:'/login', name:'Login', component: Login},
    {path:'/board/list', name:'board_list', component: List},
    {path:'/board/write', name:'board_write', component: Write},
    {path:'/board/detail', name:'board_detail', component: Detail},

    { path: '/404', component: 404  },
    { path : '/:pathMatch(.*)*', redirect : '/404'}



]

const router = createRouter({
    history : createWebHistory(),
    routes,
});


export default router
