import Vue from 'vue'
import VueRouter from 'vue-router'
import Student from '../views/Student'
import KcDetail from '../views/kcDetail'
import Teacher from '../views/Teacher'
import Home from '../views/Home'
import Login from '../views/Login'
import Course from "../views/Course";

import HomeWebsite from "@/views/HomeWebsite";
import Page1 from "@/views/Page1";
import Page2 from "@/views/Page2";

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login,
    hidden: true
  },
  {
    path:'/homeWebsite',
    name:'HomeWebsite',
    component: HomeWebsite,
    hidden: true
  },

  {
    path: '/page1',
    name: 'Page1',
    component: Page1,
    hidden: true
  },
  {
    path: '/page2',
    name: 'Page2',
    component: Page2,
    hidden: true
  },


  {
    path: '/home',
    name: 'Home',
    component: Home,
    hidden: true
  },
  {
    path: '/home',
    name: '导航一',
    component: Home,
    children:[
      {
        path: '/kcDetail',
        name: '课程介绍',
        component: KcDetail
      },
      {
        path: '/student',
        name: '管理学生',
        component: Student
      },
      {
        path: '/teacher',
        name: '管理教师',
        component: Teacher
      },
      // {
      //   path: '/Course',
      //   name:'课程网站',
      //   component: Course
      // }
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
