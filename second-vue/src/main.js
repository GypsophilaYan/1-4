import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import store from './store'
import {findAllMenus} from "./config/menu";

Vue.config.productionTip = false
Vue.prototype.$axios = axios
Vue.use(ElementUI)

//拦截器，过滤器
router.beforeEach((to,from,next)=> {
  if(to.path === '/') {
    next();              //进行下一步，不做拦截
  } else {
    if (window.sessionStorage.getItem("user")) {
      findAllMenus(router,store)
      next();
    } else {
      next("/?redirect="+to.path)
    }
  }
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
