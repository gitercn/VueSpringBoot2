<template>
  <div class="expense">
    <div style="margin:20px auto;width:120px;height:120px;border-radius:100px;overflow:hidden">
      <img src="@/assets/picture/picture1.jpg" style="margin:0;width:100%;height:100%;">
    </div>
    <div>
      <p style="text-align:center">[{{json.employeeId }}] {{json.employeeName }}</p>
    </div>
    <br>
    <div class="mdui-card mdui-ripple" height="400px;">
      <div class="mdui-card-media"></div>
      <div class="mdui-card-actions">
        <div style="font-size:8px">&nbsp;</div>
        <div style="font-size:18px">
          Account and Security
          <span style="float:right">></span>
        </div>
        <div style="font-size:8px">&nbsp;</div>
      </div>
    </div>
    <br>
    <div class="mdui-card mdui-ripple" height="400px;">
      <div class="mdui-card-media"></div>
      <div class="mdui-card-actions">
        <div style="font-size:8px">&nbsp;</div>
        <div style="font-size:18px">
          New Message Notification
          <span style="float:right">></span>
        </div>
        <div style="font-size:8px">&nbsp;</div>
      </div>
    </div>
    <br>
    <div class="mdui-card mdui-ripple" height="400px;">
      <div class="mdui-card-media"></div>
      <div class="mdui-card-actions">
        <div style="font-size:8px">&nbsp;</div>
        <div style="font-size:18px">
          Help and Feedback
          <span style="float:right">></span>
        </div>
        <div style="font-size:8px">&nbsp;</div>
      </div>
    </div>
    <br>
    <router-link to="/login">
      <div class="mdui-card mdui-ripple" height="100px;">
        <div class="mdui-card-media"></div>
        <div class="mdui-card-actions">
          <!-- <div style="font-size:10px">&nbsp;</div> -->
          <div style="font-size:18px">
            <p style="text-align:center">Sign Out</p>
          </div>
          <!-- <div style="font-size:10px">&nbsp;</div> -->
        </div>
      </div>
    </router-link>
  </div>
</template>

<script>
import mdui from 'mdui';
import { globalStore } from "./globalStore.js";
export default {
  data() {
    return {
      json: globalStore.jsonForGlobal,
    };
  },
  methods: {
    switchPageFromComponent(login) {
      this.$emit("switchPageFromComponent", login);
    }
    // switchPageFromComponent(detailId) {
    //   this.$emit("switchPageFromComponent", detailId);
    // }
  }
};
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
