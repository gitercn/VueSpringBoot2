<template>
  <div class="login2">
    <div style="padding:0 20px">
      <form class="content__form contact-form" id="register-form" method="post">
        <v-btn v-on:click="insert3()">插入三个员工的数据insert3</v-btn>
        <br>
        <v-btn v-on:click="insertcombo()">插入combo表数据</v-btn>

        <div class="mdui-textfield mdui-textfield-floating-label">
          <i class="mdui-icon material-icons">account_circle</i>
          <label class="mdui-textfield-label">User ID</label>
          <input class="mdui-textfield-input" v-model="loginInfoVo.username">
        </div>

        <div style="margin-bottom:10px">
          <div class="mdui-textfield mdui-textfield-floating-label">
            <i class="mdui-icon material-icons">lock</i>
            <label class="mdui-textfield-label">Password</label>
            <input class="mdui-textfield-input" v-model="loginInfoVo.password">
          </div>
        </div>
        <v-btn v-on:click="login1()">测试登录login1</v-btn>
        <br>登录验证情况：
        <br>
        <textarea cols="30" rows="10" v-model="responseResult"></textarea>
        <br>
      </form>
    </div>
  </div>
</template>

<script>
import mdui from "mdui";
import { globalStore } from "./globalStore.js";
export default {
  //employeeIdFromLogin,
  name: "login2",
  data() {
    return {
      employeeIdFromLogin: "",
      passwordFromLogin: "",
      jsonLocal: globalStore.jsonForGlobal,
      jsonForCurrent: null,
      loginInfoVo: { username: "", password: "" },
      responseResult: []
    };
  },
  methods: {
    login1() {
      this.$axios
        .post("/login1", {
          username: this.loginInfoVo.username,
          password: this.loginInfoVo.password
        })
        .then(successResponse => {
          this.responseResult = JSON.stringify(successResponse.data);
          if (successResponse.data.code === 200) {
            // this.$router.replace({ path: "/index" });
          }
        })
        .catch(failResponse => {
          console.log(failResponse);
        });
    },
    insert3() {
      this.$axios
        .post("/insert3", {
          username: this.loginInfoVo.username,
          password: this.loginInfoVo.password
        })
        .then(successResponse => {
          this.responseResult = JSON.stringify(successResponse.data);
          if (successResponse.data.code === 200) {
            // this.$router.replace({ path: "/index" });
          }
        })
        .catch(failResponse => {
          console.log(failResponse);
        });
    },
    insertcombo() {
      this.$axios
        .post("/insertcombo", {
          username: this.loginInfoVo.username,
          password: this.loginInfoVo.password
        })
        .then(successResponse => {
          this.responseResult = JSON.stringify(successResponse.data);
          if (successResponse.data.code === 200) {
            // this.$router.replace({ path: "/index" });
          }
        })
        .catch(failResponse => {
          console.log(failResponse);
        });
    },
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
    Register() {
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
