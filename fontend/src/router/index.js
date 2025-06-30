import { createRouter, createWebHistory } from 'vue-router';
import Login from '../components/HelloWorld.vue';
import Home from '../components/home.vue';
import register from '../components/register.vue';
import avatar from '../components/avata.vue';
import otp from '../components/otp.vue';


const routes = [
  { path: '/duy123',name:"home", component: Home },
  { path: '/login',name:"login", component: Login },
  { path: '/add',name:"register" ,component: register },
  { path: '/upload',name:"avata" ,component: avatar },
  { path: '/otp',name:"otp" ,component: otp },

];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;