import {createRouter, createWebHistory} from "vue-router";
import Garden from "@/components/garden/Garden.vue";
import CreateGarden from "@/components/garden/CreateGarden.vue";
import Journal from "@/components/journal/Journal.vue";
import Plants from "@/components/plants/Plants.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "Garden",
      component: Garden,
    },
    {
      path: "/create",
      name: "Create Garden",
      component: CreateGarden
    },
    {
      path: "/journal",
      name: "Journal",
      component: Journal,
    },
    {
      path: "/plants",
      name: "Plants",
      component: Plants,
    },
  ],
});

export default router;
