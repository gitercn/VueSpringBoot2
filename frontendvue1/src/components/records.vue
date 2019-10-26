<template>
  <div class="records">
    <mu-tabs v-bind:value.sync="tabNumber" color="cyan" indicator-color="white" full-width>
      <mu-tab v-if="requestTabShow" v-on:click="switchTab()">Request List</mu-tab>
      <mu-tab v-if="acceptanceTabShow" v-on:click="switchTab()">Acceptance List</mu-tab>
      <mu-tab v-if="approvalTabShow" v-on:click="switchTab()">Approval List</mu-tab>
    </mu-tabs>
    <div v-if="tabNumber === tab0">
      <ul class="mdui-list">
        <div
          　v-for="item in json.records"
          v-bind:key="item.recordId"
          v-if="item.requesterId == json.employeeId"
        >
          <li
            class="mdui-list-item mdui-ripple"
            v-on:click="switchPageFromComponent('detail', '' , item.detailId, 'records', '0')"
          >
            <div class="mdui-list-item-content">
              <div class="mdui-list-item-title">
                <img
                  :src="item.status==='Cancelled'?getImgUrl('cancelled'):item.status==='Approved'?getImgUrl('approved'):getImgUrl('pending')"
                  style="width:15px;height:15px"
                >
                <span style="font-size:14px;">{{item.requestType}} Request {{item.requestId}}</span>
                <mu-chip
                  class="status demo-chip"
                  style="height:20px;weight:100px;margin-top:5px"
                  :color="item.status=='Checking'?'#FFBA6D':item.status==='Revising'?'#F4430C':item.status==='Approved'?'#0066FF':item.status==='Cancelled'?'#C0C0C0':'#ED7D31'"
                >{{item.status}}</mu-chip>
              </div>
              <div class="mdui-list-item-text mdui-list-item-one-line">
                <span
                  class="mdui-text-color-theme-text"
                >{{item.currentApproverId }} {{item.currentApprover }}</span>
              </div>
            </div>
          </li>
          <li class="mdui-divider-inset mdui-m-y-0"></li>
        </div>
      </ul>
    </div>
    <div v-if="tabNumber === tab1">
      <ul class="mdui-list">
        <div
          　v-for="item in json.records"
          v-bind:key="item.recordId"
          v-if="item.receptionistId == json.employeeId"
        >
          <li
            class="mdui-list-item mdui-ripple"
            v-on:click="switchPageFromComponent('detail', '', item.detailId, 'records', '1')"
          >
            <div class="mdui-list-item-content">
              <div class="mdui-list-item-title">
                <img
                  :src="item.status==='Cancelled'?getImgUrl('cancelled'):item.status==='Approved'?getImgUrl('approved'):getImgUrl('pending')"
                  style="width:15px;height:15px"
                >
                <span style="font-size:14px;">{{item.requestType}} Request {{item.requestId}}</span>
                <mu-chip
                  class="status demo-chip"
                  style="height:20px;weight:100px;margin-top:5px"
                  :color="item.status=='Checking'?'#FFBA6D':item.status==='Revising'?'#F4430C':item.status==='Approved'?'#0066FF':item.status==='Cancelled'?'#C0C0C0':'#ED7D31'"
                >{{item.status}}</mu-chip>
              </div>
              <div class="mdui-list-item-text mdui-list-item-one-line">
                <span
                  class="mdui-text-color-theme-text"
                >{{item.currentApproverId }} {{item.currentApprover }}</span>
              </div>
            </div>
          </li>
          <li class="mdui-divider-inset mdui-m-y-0"></li>
        </div>
      </ul>
    </div>
    <div v-if="tabNumber === tab2">
      <ul class="mdui-list">
        <div
          　v-for="item in json.records"
          v-bind:key="item.recordId"
          v-if="item.authorizerId == json.employeeId"
        >
          <li
            class="mdui-list-item mdui-ripple"
            v-on:click="switchPageFromComponent('detail', '', item.detailId, 'records', '2')"
          >
            <div class="mdui-list-item-content">
              <div class="mdui-list-item-title">
                <img
                  :src="item.status==='Cancelled'?getImgUrl('cancelled'):item.status==='Approved'?getImgUrl('approved'):getImgUrl('pending')"
                  style="width:15px;height:15px"
                >
                <span style="font-size:14px;">{{item.requestType}} Request {{item.requestId}}</span>
                <mu-chip
                  class="status demo-chip"
                  style="height:20px;weight:100px;margin-top:5px"
                  :color="item.status=='Checking'?'#FFBA6D':item.status==='Revising'?'#F4430C':item.status==='Approved'?'#0066FF':item.status==='Cancelled'?'#C0C0C0':'#ED7D31'"
                >{{item.status}}</mu-chip>
              </div>
              <div class="mdui-list-item-text mdui-list-item-one-line">
                <span
                  class="mdui-text-color-theme-text"
                >{{item.currentApproverId }} {{item.currentApprover }}</span>
              </div>
            </div>
          </li>
          <li class="mdui-divider-inset mdui-m-y-0"></li>
        </div>
      </ul>
    </div>
  </div>
</template>

<script>
import mdui from "mdui";
import { globalStore } from "./globalStore.js";
// import global_ from '../../components/Global'//引用模块进来
export default {
  props: ["dataReturnToTab"],
  data() {
    return {
      // json: this.GLOBAL2.jsonForGlobal, //直接通过this访问全局变量。
      json: globalStore.jsonForGlobal,
      requestTabShow: false,
      acceptanceTabShow: false,
      approvalTabShow: false,
      tabNumber: 0,
      // dataReturnToTab: 0,
      tab0: 0,
      tab1: 1,
      tab2: 2
    };
  },
  created() {
    //////////////////////////////////
    //根据员工级别Tab显示隐藏-->
    globalStore.jsonForGlobal;
    if (globalStore.jsonForGlobal.employeeLevel == "1") {
      this.requestTabShow = true;
      //受付タブを隠す
      this.acceptanceTabShow = false;
      //承認タブを隠す
      this.approvalTabShow = false;
      //绑定tab和下面的内容
      this.tab0 = 0;
      this.tab1 = 1;
      this.tab2 = 2;
    } else if (globalStore.jsonForGlobal.employeeLevel == "2") {
      this.requestTabShow = true;
      this.acceptanceTabShow = true;
      //承認タブを隠す
      this.approvalTabShow = false;
      //绑定tab和下面的内容
      this.tab0 = 0;
      this.tab1 = 1;
      this.tab2 = 2;
      // 显示的tab
      if ((this.dataReturnToTab == 0)) {
        this.tabNumber = 0;
      } else {
        this.tabNumber = 1;
      };
    } else if (globalStore.jsonForGlobal.employeeLevel == "3") {
      //受付タブを隠す
      this.requestTabShow = true;
      this.acceptanceTabShow = false;
      this.approvalTabShow = true;
      //绑定tab和下面的内容
      this.tab0 = 0;
      this.tab1 = 2;
      this.tab2 = 1;
      if ((this.dataReturnToTab == 0)) {
        this.tabNumber = 0;
      } else {
        this.tabNumber = 1;
      };
    }
    //////////////////////////////////<--根据员工级别Tab显示隐藏 End

    //////////////////////////////////<--创建时激活的tab
    console.log("dataReturnToTab" + this.dataReturnToTab);
  },
  name: "records",
  methods: {
    //获取record状态图片
    getImgUrl(pet) {
      var images = require.context("../assets/picture/", false, /\.png$/);
      return images("./" + pet + ".png");
    },
    switchPageFromComponent(
      pageName,
      employeeIdFromLogin,
      detailId,
      returnTo,
      returnToTab
    ) {
      this.$emit(
        "switchPageFromComponent",
        pageName,
        employeeIdFromLogin,
        detailId,
        returnTo,
        returnToTab
      );
    },
    switchTab(){
      console.log("tabnumber="+this.tabNumber);
      console.log("dataReturnToTab="+this.dataReturnToTab);
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.status {
  float: right;
}
</style>
