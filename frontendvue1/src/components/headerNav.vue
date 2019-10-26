<template>
  <div class="headerNav">
    <!-- jsonlocal{{json.employeeId }} -->
    <mu-appbar style="width: 100%;" color="#00BCD4">
      <div >
      <img
        class="mdui-img-circle"
        style="position: absolute;left: 34px;top: 19px;height: 5px; z-index: 3"
        src="@/assets/picture/red.jpg"
      >
      </div>
      <mu-button style="z-index:1;" icon slot="left" @click="open = !open">
        <mu-icon value="menu"></mu-icon>
      </mu-button>
      <div style="text-align: center; text-transform: capitalize;">{{pageNameForHeader}}</div>
      <mu-button flat slot="right" v-on:click="switchPage('login2')">
        <mu-icon value="search"></mu-icon>
      </mu-button>
    </mu-appbar>

    <mu-drawer :open.sync="open" :docked="docked" :right="position === 'right'">
      <div>
        <div>
          <img
            class="mdui-img-circle"
            style="position: absolute;left: 15px;top: 10px;height: 80px; z-index: 2"
            src="@/assets/picture/picture1.jpg"
          >
        </div>
        <div
          style=" position: absolute;left: 10px;top: 10px;margin-left: 30px;margin-top: 100px;color:white;z-index: 2;"
        >
          <!-- 展示员工姓名employeeName -->
          {{ json.employeeName }}
        </div>
        <div class="mdui-ripple">
          <img height="160" src="@/assets/picture/nav_header_bg.jpg">
        </div>
      </div>

      <mu-list>
        <mu-list-item
          button
          :ripple="false"
          v-on:click="switchPage('home');open = !open"
          class="mdui-ripple"
        >
          <mu-list-item-action title="Home">
            <mu-icon value="home"></mu-icon>
          </mu-list-item-action>
          <mu-list-item-title>Home</mu-list-item-title>
        </mu-list-item>
        <!-- </router-link> -->
        <!-- <router-link :to="{'name':'login'}"> -->
        <mu-list-item
          button
          :ripple="false"
          v-on:click="switchPage('messages');open = !open"
          class="mdui-ripple"
        >
        <div >
      <img
        class="mdui-img-circle"
        style="position: absolute;left: 36px;top: 12px;height: 5px; z-index: 3"
        src="@/assets/picture/red.jpg"
      >
      </div>
          <mu-list-item-action title="Message">
            <mu-icon value="message"></mu-icon>
          </mu-list-item-action>
          <mu-list-item-title>Message</mu-list-item-title>
        </mu-list-item>
        <!-- </router-link> -->
        <!-- <router-link :to="{'name':'login'}"> -->
        <mu-list-item
          button
          :ripple="false"
          v-on:click="switchPage('records');open = !open"
          class="mdui-ripple"
        >
          <mu-list-item-action title="Record">
            <mu-icon value="event_note"></mu-icon>
          </mu-list-item-action>
          <mu-list-item-title>Record</mu-list-item-title>
        </mu-list-item>
        <!-- </router-link> -->
        <!-- <router-link :to="{'name':'login'}"> -->
        <mu-list-item
          button
          :ripple="false"
          v-on:click="switchPage('settings');open = !open"
          class="mdui-ripple"
        >
          <mu-list-item-action title="setting">
            <mu-icon value="settings"></mu-icon>
          </mu-list-item-action>
          <mu-list-item-title>Settings</mu-list-item-title>
        </mu-list-item>
        <!-- </router-link> -->
      </mu-list>
    </mu-drawer>
  </div>
</template>
<script>
import mdui from "mdui";
import { globalStore } from "./globalStore.js";
export default {
  props: ["pageNameForHeader", "employeeIdFromLogin"],
  // employeeIdFromLogin,
  data() {
    return {
      docked: false,
      open: false,
      position: "left",
      userinfo: {},
      json: globalStore.jsonForGlobal
    };
  },
  mounted() {},
  methods: {
    switchPage(pageName) {
      this.$emit("switchPage", pageName);
    }
  }
};
</script>
<style scoped>
</style>