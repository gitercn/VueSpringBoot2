<template>
  <div id="app">
    <div id="loginCheck">
      <router-link v-if="authenticated" to="/login" v-on:click.native="logout()"></router-link>
    </div>
    <router-view
      v-on:authenticated="setAuthenticated"
      v-on:switchPageFromLogin="switchPageFromLogin"
    />
  </div>
</template>

<script>
// import 'mdui/dist/js/mdui.js';
import mdui from 'mdui';
export default {
  name: "App",
  // name: 'app',
  data() {
    return {
      authenticated: false,
      mockAccount1: {
        username: "10000001",
        password: ""
      },
      mockAccount2: {
        username: "20000001",
        password: ""
      },
      mockAccount3: {
        username: "30000001",
        password: ""
      }
    };
  },
  mounted() {
    if (!this.authenticated) {
      this.$router.replace({ name: "login" });
    }
  },
  methods: {
    setAuthenticated(status) {
      this.authenticated = status;
    },
    switchPageFromLogin(pageName2, employeeIdFromLogin, detailId, jsonFromLogin) {
      this.currentPage = pageName2;
      this.employeeIdFromLogin = employeeIdFromLogin;
      this.detailId = detailId;
      this.jsonForCurrent = jsonFromLogin;
    },
    logout() {
      this.authenticated = false;
    }
  },
  components: {}
};
</script>

<style>
</style>
