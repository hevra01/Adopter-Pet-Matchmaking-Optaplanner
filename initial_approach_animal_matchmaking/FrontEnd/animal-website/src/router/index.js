import {createRouter, createWebHistory} from "vue-router";
import LoginPage from "@/views/LoginPage";
import RegisterPage from "@/views/RegisterPage";
import ContactPage from "@/views/ContactPage";
import AdopterPage from "@/views/AdopterPage";
import AnimalAddPage from "@/views/AnimalAddPage";

const routes = [
  {
    path: "/",
    name: "login",
    component: LoginPage,
  },
  {
    path: "/register",
    name: "register",
    component: RegisterPage,
  },
  {
    path: "/contact",
    name: "contact",
    component: ContactPage,
  },
  {
    path: "/adopterview",
    name: "adopterview",
    component: AdopterPage,
  },
  {
    path: "/addpet",
    name: "addpet",
    component: AnimalAddPage,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
