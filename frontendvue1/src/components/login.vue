<template>
  <div class="login">
    <mu-appbar style="width: 100%;" color="#00BCD4">
      <!-- <mu-button icon slot="left" @click="open = !open"> -->
        <!-- <mu-icon value="menu"></mu-icon> -->
      <!-- </mu-button> -->
      <div style="text-align: center; text-transform: capitalize;">Login</div>
      <!-- <mu-button flat slot="right" v-on:click="switchPage('detail')"> -->
        <!-- <mu-icon value="search"></mu-icon> -->
      <!-- </mu-button> -->
    </mu-appbar>
    <div class="easyui-navpanel">
      <br>
      <br>
      <div style="margin:auto;width:100px;height:100px;border-radius:100px;overflow:hidden">
        <img src="@/assets/picture/picture1.jpg" style="margin-bottom:0px;width:100%;height:100%;">
      </div>
      <div style="padding:0 20px">
        <form class="content__form contact-form" id="register-form" method="post">
          <div>
            <div class="mdui-textfield mdui-textfield-floating-label">
              <i class="mdui-icon material-icons">account_circle</i>
              <label class="mdui-textfield-label">User ID</label>
              <input class="mdui-textfield-input" v-model="employeeIdFromLogin" />
            </div>
          </div>
          <div style="margin-bottom:10px">
            <div class="mdui-textfield mdui-textfield-floating-label">
              <i class="mdui-icon material-icons">lock</i>
              <label class="mdui-textfield-label">Password</label>
              <input class="mdui-textfield-input" v-model="passwordFromLogin" />
            </div>
          </div>
          <br>
          <div style="text-align:center;margin-top:30px">
            <!-- <router-link to="/index"> -->
            <a
              class="mdui-btn mdui-ripple"
              style="width:100%;height:40px;border: 1px solid gainsboro"
              v-on:click="login1()"
            >
              <span style="font-size:16px;">Login</span>
            </a>
            <!-- </router-link> -->
          </div>
          <div style="text-align:center;margin-top:30px">
            <!-- <router-link to="/register"> -->
            <a
              class="mdui-btn mdui-ripple"
              plain="true"
              outline="true"
              style="width:120px;height:40px;border: 1px solid gainsboro"
              v-on:click="login()"
            >
              <span style="font-size:16px;text-align: center;">Register</span>
            </a>
            <!-- </router-link> -->
          </div>
        </form>
        <br>
        <textarea cols="30" rows="10" v-model="responseResult"></textarea>
        <br>
      </div>
    </div>
  </div>
</template>

<script>
import mdui from "mdui";
import { globalStore } from "./globalStore.js";
export default {
  //employeeIdFromLogin,
  name: "login",
  data() {
    return {
      employeeIdFromLogin: "",
      passwordFromLogin: "",
      jsonLocal: globalStore.jsonForGlobal,
      jsonForCurrent: null,
      // loginInfoVo: { username: this.employeeIdFromLogin, password: this.passwordFromLogin },
      responseResult: []
    };
  },
  methods: {
    switchPageFromComponent(pageName, employeeIdFromLogin, detailId) {
      console.log(detailId);
      console.log("employeeIdFromLogin=" + employeeIdFromLogin);
      this.$emit(
        "switchPageFromComponent",
        pageName,
        employeeIdFromLogin,
        detailId
      );
    },
    login1() {
      this.$axios
        .post("/login1", {
          username: this.employeeIdFromLogin,
          password: this.passwordFromLogin
        })
        .then(successResponse => {
          this.responseResult = JSON.stringify(successResponse.data);
          if (successResponse.data.code === 200) {
            // alert("Login Success");
            this.$router.replace({ path: "/index" });
          }
        })
        .catch(failResponse => {
          console.log(failResponse);
        });
    },
    login() {
      if (this.employeeIdFromLogin != "" && this.password != "") {
        if (
          (this.employeeIdFromLogin == this.$parent.mockAccount1.username ||
            this.employeeIdFromLogin == this.$parent.mockAccount2.username ||
            this.employeeIdFromLogin == this.$parent.mockAccount3.username) &&
          this.passwordFromLogin == this.$parent.mockAccount1.password
        ) {
          console.log("employeeIdFromLogin=" + this.employeeIdFromLogin);
          this.$emit(
            "switchPageFromLogin",
            "",
            this.employeeIdFromLogin,
            "",
            this.jsonForCurrent
          );
          this.$emit("authenticated", true);
          this.$router.replace({ name: "index" });
        } else {
          alert("Please input User ID and Password.");
        }
      } else {
        alert("Please input User ID and Password");
      }
    },
    register() {
      this.$router.replace({ name: "register" });
    }
  },
  watch: {
    employeeIdFromLogin: {
      handler(newVal, oldVal) {
        console.log("newVal=" + newVal + "===" + "oldVal=" + oldVal);
        const data = require("./json/" + this.employeeIdFromLogin + ".json");
        console.log("OK");
        console.log(data);
        this.jsonForCurrent = data;
        globalStore.jsonForGlobal = data;
      }
    }
  }
  // created: function() {
  //   this.$emit("header", false);
  // }
};
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
