import { createRouter, createWebHistory } from "vue-router";
import SalesList from "../views/SalesList.vue";
import ProductDetail from "../views/ProductDetail.vue";
import ProductList from "../views/ProductList.vue";

const routes = [
    {
        path: "/",
        name: "ProductList",
        component: ProductList,
    },
    {
        path: "/about",
        name: "about",
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
    },
    {
        path: "/sales",
        name: "SalesList",
        component: SalesList,
    },
    {
        path: "/detail",
        name: "ProductDetail",
        component: ProductDetail,
    },
];

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes,
});

export default router;
