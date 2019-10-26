<template>
  <div class="messages">
    <!-- <div v-for="(block,index) in employeeId" :key="index">
      <div></div>
      <div>{{block }}</div>
    </div>
    <div v-for="item in json.message">
      <div></div>
      <div>{{item.message }}</div>
    </div>-->
    <!-- <div>{{ jsonFileCurrent.employeeName }}</div> -->
    <ul class="mdui-list">
      <div v-for="item in json.message" v-bind:key="item.messageId">
        <li
          class="mdui-list-item mdui-ripple"
          v-on:click="switchPageFromComponent('detail','', item.detailId, 'messages')"
        >
        <div >
      <img
        class="mdui-img-circle"
        style="position: absolute;left: 50px;top: 15px;height: 5px; z-index: 3"
        src="@/assets/picture/red.jpg"
      >
      </div>        
          <div class="mdui-list-item-avatar">
            <img src="@/assets/picture/picture1.jpg">
          </div>
          <div class="mdui-list-item-content">
            <div class="mdui-list-item-title">
              {{item.requestType}} Request
              <span class="senddate">{{item.sendDate}}</span>
            </div>
            <div class="mdui-list-item-text mdui-list-item-one-line">
              <span class="mdui-text-color-theme-text">{{item.requesterName}} {{item.message }}</span>
            </div>
          </div>
        </li>
        <li class="mdui-divider-inset mdui-m-y-0"></li>
      </div>
    </ul>
  </div>
</template>

<script>
import mdui from 'mdui';
import { globalStore } from "./globalStore.js";
// import global_ from '../../components/Global'//引用模块进来
export default {
  data() {
    return {
      // json: this.GLOBAL2.jsonForGlobal, //直接通过this访问全局变量。
      json: globalStore.jsonForGlobal,
    };
  },
  name: "messages",
  methods: {
    switchPageFromComponent(pageName, employeeIdFromLogin, detailId, returnTo) {
      this.$emit("switchPageFromComponent", pageName, employeeIdFromLogin, detailId, returnTo);
    },
    // switchPageFromComponent(detailId) {
    //   this.$emit("switchPageFromComponent", detailId);
    // }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.senddate {
  float: right;
  font-weight: 200;
}
</style>
