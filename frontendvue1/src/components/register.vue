<template>
  <div class="register">
    <mu-appbar style="width: 100%;" color="#00BCD4">
      <!-- <mu-button icon slot="left" @click="open = !open"> -->
        <!-- <mu-icon value="menu"></mu-icon> -->
      <!-- </mu-button> -->
      <div style="text-align: center; text-transform: capitalize;">Register</div>
      <!-- <mu-button flat slot="right" v-on:click="switchPage('detail')"> -->
        <!-- <mu-icon value="search"></mu-icon> -->
      <!-- </mu-button> -->
    </mu-appbar>
    <div class="easyui-navpanel">
      <br>
      <br>
      <div style="margin:auto;width:100px;height:100px;border-radius:100px;overflow:hidden">
        <img src="@/assets/picture/picture2.png" style="margin-bottom:0px;width:100%;height:100%;">
      </div>
      <div style="padding:0 20px">
        <form class="content__form contact-form" id="register-form" method="post">
          <div>
            <div class="mdui-textfield mdui-textfield-floating-label">
              <i class="mdui-icon material-icons">account_circle</i>
              <label class="mdui-textfield-label">User ID</label>
              <textarea class="mdui-textfield-input"></textarea>
            </div>
          </div>
          <div style="margin-bottom:10px">
            <div class="mdui-textfield mdui-textfield-floating-label">
              <i class="mdui-icon material-icons">lock</i>
              <label class="mdui-textfield-label">Password</label>
              <textarea class="mdui-textfield-input"></textarea>
            </div>
          </div>
          <br>
          <div style="text-align:center;margin-top:30px">
            <a
              class="mdui-btn mdui-ripple"
              style="width:100%;height:40px;border: 1px solid gainsboro"
              v-on:click="Register()"
            >
              <span style="font-size:16px;">Register</span>
            </a>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import mdui from 'mdui';
export default {
  name: "register",
  methods: {
    Register() {
      this.$router.replace({ name: "login" });
    }
  }
};
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
