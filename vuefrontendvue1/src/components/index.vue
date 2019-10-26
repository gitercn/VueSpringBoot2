<template>
  <div class="indexvue">
    <!-- {{employeeIdFromLogin}} -->
    <headerNav
      v-on:switchPage="switchPage"
      v-if="header_show"
      v-bind:employeeIdFromLogin="employeeIdFromLogin"
      v-bind:pageNameForHeader="currentPage"
    ></headerNav>
    <component
      v-bind:is="currentPage"
      v-on:switchPageFromComponent="switchPageFromComponent"
      v-on:header="header"
      v-bind:dataDetailId="detailId"
      v-bind:dataReturnTo="returnTo"
      v-bind:dataReturnToTab="returnToTab"
    ></component>
  </div>
</template>

<script>
import headerNav from "./headerNav.vue";
import home from "./home.vue";
import messages from "./messages.vue";
import expense from "./expense.vue";
import records from "./records.vue";
import settings from "./settings.vue";
import detail from "./detail.vue";
import login from "./login.vue";
import proposal from "./proposal";
import register from "./register";
import login2 from "./login2.vue";
import expense2 from "./expense2.vue";

export default {
  name: "indexvue",
  data() {
    return {
      
      currentPage: "home",
      detailId: "",
      header_show: true,
      employeeIdFromLogin: "",
      returnTo:"",
      returnToTab: 0,
    };
  },
  methods: {
    switchPage(pageName) {
      this.currentPage = pageName;
    },
    switchPageFromComponent(pageName2, employeeIdFromLogin, detailId, returnTo, returnToTab) {
      this.currentPage = pageName2;
      this.detailId = detailId;
      this.employeeIdFromLogin = employeeIdFromLogin;
      this.returnTo = returnTo;
      this.returnToTab = returnToTab;
    },
    //是否显示头部
    header: function(bool) {
      this.header_show = bool;
    }
  },
  components: {
    headerNav,
    home,
    messages,
    expense,
    records,
    settings,
    detail,
    login,
    proposal,
    register,
    login2,
    expense2,
  }
};
</script>

<style scoped>
</style>
