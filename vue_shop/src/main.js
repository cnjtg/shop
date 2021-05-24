import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'

import './plugins/element.js'
import './assets/global.css'

Vue.config.productionTip = false
axios.defaults.baseURL= 'http://localhost/api'
Vue.prototype.$http= axios


new Vue({
  router,
  axios,
  render: h => h(App)
}).$mount('#app')
