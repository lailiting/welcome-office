import {
  createRouter,
  createWebHashHistory
} from "vue-router"

const routes = [
    {
        path: '/',
        // component: () => import('../views/Home.vue')             
        component: () => import ('../views/home/index.vue')
    }, {
      path: '/home',
      // component: () => import('../views/Home.vue')             
      component: () => import ('../views/home/index.vue')
  },
    {
      path: '/StudioAwards',
      component: () => import('../views/StudioAwards.vue')             
    },
    {
      path:'/connect',
      component: () => import ('../views/connect/index.vue')
    },
    {
      path:'/4',
      component: ()=>import('../views/studySource/index.vue')
    },
    {
      path:"/daily",
      component: () => import('../views/StudioDaily/index.vue')
    },
    {
      path:"/member",
      component: () => import('../views/StudioMember/index.vue')
    }
]
export const router = createRouter({
  history: createWebHashHistory(),
  routes: routes
})

router.afterEach((to, from) => {
  sessionStorage.setItem('path', to.fullPath)
})

export default router