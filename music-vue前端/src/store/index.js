import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    isLogin: false,
    userinfo: {
      username: "",
      password: "",
    },
  },
  mutations: {
    loginto(state) {
      state.isLogin = true;
    },
    loginbackto(state) {
      state.isLogin = false;
    },
    record(state, info) {
      state.userinfo.username = info[0];
      state.userinfo.password = info[1];
    },
  },
  actions: {},
  modules: {},
});
