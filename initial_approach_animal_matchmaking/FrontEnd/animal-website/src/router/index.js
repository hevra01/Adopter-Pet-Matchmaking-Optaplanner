import {createRouter, createWebHistory} from 'vue-router'
import LoginPage from "@/views/LoginPage";
import RegisterPage from "@/views/RegisterPage";
import ContactPage from "@/views/ContactPage";
import AdopterPage from "@/views/AdopterPage";

const routes = [
  {
    path: '/',
    name: 'login',
    component: LoginPage
  },
  {
    path: '/register',
    name: 'register',
    component: RegisterPage
  },
  {
    path: '/contact',
    name: 'contact',
    component: ContactPage
  },
  {
    path: '/adopterview',
    name: 'adopterview',
    component: AdopterPage
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
