<template>
  <div class="detail">
    <v-app>
      <div style="position:relative; z-index:1">
        <v-btn
          fab
          dark
          color="#00BCD4"
          v-on:click="switchPageFromComponent(dataReturnTo,'', detailId, 'detail', returnToTab)"
        > 
          <v-icon dark>arrow_back</v-icon>
        </v-btn>
      </div>
      <div style="padding:0 25px 10px 25px">
        <div id="list">
          <p style="text-align: center">
            <span id="requestId">[ {{json.detail[detailId].requestId}} ]</span>
          </p>
          <p style="text-align: right">
            Current Status:
            <span
              id="currentStatus"
              v-bind:style="json.detail[detailId].currentStatus=='Checking'?'color: #FFBA6D':json.detail[detailId].currentStatus==='Revising'?'color: #F4430C':json.detail[detailId].currentStatus==='Approved'?'color: #0066FF':json.detail[detailId].currentStatus==='Cancelled'?'color: #C0C0C0':'color: #ED7D31'"
            >{{json.detail[detailId].currentStatus}}</span>
          </p>
          <p style="text-align: right">
            Current Approver:
            <span id="currentApprover">{{json.detail[detailId].currentApprover}}</span>
          </p>
          <!-- <div class="mdui-container"> -->
          <table style="width:100%;border-collapse:separate; border-spacing:0px 10px;">
            <tr>
              <td style="width:50%">Date on Request:</td>
              <td style="width:50%">
                <span id="dateOnRequest">{{json.detail[detailId].dateOnRequest}}</span>
              </td>
            </tr>
            <tr>
              <td>Requester:</td>
              <td>
                <span
                  id="requesterName"
                >[{{json.detail[detailId].requesterId}}] {{json.detail[detailId].requesterName}}</span>
              </td>
            </tr>
            <tr>
              <td>Receptionist:</td>
              <td>
                <span id="receptionist"></span>
                [{{json.detail[detailId].receptionistId}}] {{json.detail[detailId].receptionist}}
              </td>
            </tr>
            <tr>
              <td>Authorizer:</td>
              <td>
                <span
                  id="authorizer"
                >[{{json.detail[detailId].authorizerId}}] {{json.detail[detailId].authorizer}}</span>
              </td>
            </tr>
            <tr>
              <td>Previous Approver:</td>
              <td>
                <span
                  id="previousApprover"
                >[{{json.detail[detailId].previousApproverId}}] {{json.detail[detailId].previousApprover}}</span>
              </td>
            </tr>
            <tr>
              <td>
                <p>&ensp;</p>
              </td>
              <td></td>
            </tr>
            <tr>
              <td>Request Type:</td>
              <td id="requestType">
                <!-- v-model -->
                <div id="selectedRequestTypeDiv">
                  <select class="mdui-select" style="width: 100%;" v-model="selectedRequestType" v-bind:disabled="requestTypeEditable">
                    <option>Expense</option>
                    <option>Travel</option>
                  </select>
                  <!-- <span>Selected: {{ selectedRequestType }}</span> -->
                </div>
                <!-- v-model End -->
              </td>
              <!-- <td><input type="text" name="firstname" value="Mickey"></td> -->
            </tr>
            <tr>
              <td>Date From:</td>
              <td id="dateFrom">
                <!-- v-model -->
                <div id="inputedDateFromDiv">
                  <!-- <input v-model="inputedDateFrom"> -->
                  <input
                    v-model="inputedDateFrom"
                    id="date"
                    class="mdui-select"
                    style="width: 100%;"
                    type="date"
                    v-bind:disabled="dateFromEditable"
                  >
                </div>
                <!-- v-model End -->
              </td>
            </tr>
            <tr>
              <td>Date To:</td>
              <td id="dateTo">
                <!-- v-model -->
                <div id="inputedDateToDiv">
                  <!-- <input v-model="inputedDateTo"> -->
                  <input
                    v-model="inputedDateTo"
                    id="date"
                    class="mdui-select"
                    style="width: 100%;"
                    type="date"
                    v-bind:disabled="dateToEditable"
                  >
                </div>
                <!-- v-model End -->
              </td>
            </tr>
            <tr>
              <td>Currency:</td>
              <td id="currency">
                <!-- v-model -->
                <div id="selectedCurrencyDiv">
                  <select class="mdui-select" style="width: 100%;" v-model="selectedCurrency" v-bind:disabled="currencyEditable">
                    <option value="JPY">Japanese Yen (JPY)</option>
                    <option value="CNY">Chinese Yuan Renminbi (CNY)</option>
                    <option value="USD">United States Dollar (USD)</option>
                  </select>
                </div>
                <!-- <span>Selected: {{ selectedRequestType }}</span> -->
                <!-- v-model End -->
              </td>
            </tr>
            <tr>
              <td>Account:</td>
              <td id="account">
                <!-- v-model -->
                <div id="inputedAccountDiv">
                  <!-- <input v-model="inputedAccount"> -->
                  <div class="mdui-textfield">
                    <input class="mdui-textfield-input" type="text" v-model="inputedAccount" v-bind:disabled="accountEditable">
                  </div>
                </div>
                <!-- v-model End -->
              </td>
            </tr>
          </table>
          <!-- </div> -->
        </div>
        <!-- 显示图片 -->
        <p>Attach Receipt:</p>
        <img src="@/assets/picture/ticket.jpg" style="height:120px;text-align:center;" preview="1 ">
       
        <p>&ensp;</p>
        <!-- 上传图片 -->

        <div style="padding:10px">
          <p>Feedback:</p>
          <textarea
            style="width:100%;border: 1px solid black;"
            rows="5"
            v-model="feedbackDisplayContent"
            v-bind:disabled="feedbackEditable"
          ></textarea>
          <!-- <textarea style="width:100%" rows="5" v-model="feedbackDisplayContent"></textarea> -->
        </div>
        <p>&ensp;</p>
        <p v-if="returnDisplay">Return To:</p>
        <div v-if="returnDisplay">
          <input type="radio" id="Choice1" name="who" value="requester">
          <label for="Choice1">Requester</label>

          <input type="radio" id="Choice2" name="who" value="receptionist">
          <label for="Choice2">Receptionist</label>
        </div>
        <p>&ensp;</p>
        <button class="mdui-btn mdui-btn-raised" v-on:click="historyBtn()">{{historyBtnText}}</button>
        <p>&ensp;</p>
        <!-- 显示History的地方 -->

        <v-stepper v-if="historyShow" v-model="historynumber" vertical>
          <!-- <v-stepper value="3" vertical> -->
          <template v-for="n in historynumber">
            <v-stepper-step :key="n" :step="n" :complete="historynumber > n">
              <span
                style="text-align:left"
                v-bind:style="json.detail[detailId].history[n-1].status=='Checking'?'color: #FFBA6D':json.detail[detailId].history[n-1].status==='Revising'?'color: #F4430C':json.detail[detailId].history[n-1].status==='Approved'?'color: #0066FF':json.detail[detailId].history[n-1].status==='Cancelled'?'color: #C0C0C0':'color: #ED7D31'"
              >{{json.detail[detailId].history[n-1].status}}</span>
              <span>{{json.detail[detailId].history[n-1].message}}</span>
              <span style="text-align:right">{{json.detail[detailId].history[n-1].time}}</span>
            </v-stepper-step>

            <!-- <v-stepper-content :step="n" :key="`${n}-step`">
              <v-card
                color="grey lighten-1"
                class="mb-5"
                height="40px"
              >{{json.detail[detailId].history[n-1].message}}</v-card>
            </v-stepper-content> -->
          </template>
        </v-stepper>

        <!-- 显示History的地方 -->
        <p>&ensp;</p>
        <div class="bottomBtn" style="display:flex; flex-wrap:wrap;justify-content:space-around">
          <button
            class="mdui-btn mdui-btn-raised"
            v-if="cancelDisplay"
            v-on:click="cancelBtn(dataReturnTo,'', detailId, 'detail', returnToTab)"
          >Cancel</button>
          <button
            class="mdui-btn mdui-btn-raised"
            v-if="saveDisplay"
            v-on:click="saveBtn(dataReturnTo,'', detailId, 'detail', returnToTab)"
          >Save</button>
          <button
            class="mdui-btn mdui-btn-raised"
            v-if="pullDisplay"
            v-on:click="pullBtn(dataReturnTo,'', detailId, 'detail', returnToTab)"
          >PullBack</button>
          <button
            class="mdui-btn mdui-btn-raised"
            v-if="reviseDisplay"
            v-on:click="reviseBtn(dataReturnTo,'', detailId, 'detail', returnToTab)"
          >Revise</button>
          <button
            class="mdui-btn mdui-btn-raised"
            v-if="sendDisplay"
            v-on:click="sendBtn(dataReturnTo,'', detailId, 'detail', returnToTab)"
          >SendBack</button>
          <button
            class="mdui-btn mdui-btn-raised"
            v-if="approvalDisplay"
            v-on:click="approvalBtn(dataReturnTo,'', detailId, 'detail', returnToTab)"
          >Approval</button>
        </div>
      </div>
    </v-app>
  </div>
</template>

<script>
import mdui from "mdui";
import { globalStore } from "./globalStore.js";
// import global_ from '../../components/Global'//引用模块进来
export default {
  name: "records",
  props: ["dataDetailId", "dataReturnTo","dataReturnToTab"],
  data() {
    return {
      // json: globalStore.jsonForGlobal, //直接通过this访问全局变量。
      json: globalStore.jsonForGlobal,
      detailId: 0,
      selectedRequestType: globalStore.jsonForGlobal.detail[2].requestType,
      inputedAccount: globalStore.jsonForGlobal.detail[2].account,
      inputedDateFrom: globalStore.jsonForGlobal.detail[2].dateFrom,
      inputedDateTo: globalStore.jsonForGlobal.detail[2].dateTo,
      selectedCurrency: globalStore.jsonForGlobal.detail[2].currency,
      requestTypeEditable: false,
      dateFromEditable: false,
      dateToEditable: false,
      currencyEditable: false,
      accountEditable: false,
      feedbackDisplayContent: "",
      feedbackEditable: true,
      pullDisplay: false,
      saveDisplay: false,
      cancelDisplay: false,
      reviseDisplay: false,
      sendDisplay: false,
      approvalDisplay: false,
      returnDisplay: false,
      e1: 3,
      historyShow: true,
      // steps: 8,
      historynumber: 10,
      historyBtnText: "History-",
      returnToTab: this.dataReturnToTab
    };
  },
  created() {
    console.log(globalStore.jsonForGlobal.detail[2].requesterName);
    console.log(this.dataDetailId);
    
    console.log("dataReturnToTab="+this.dataReturnToTab);
    ///////////////////////
    //查找json里detailId对应的index用于显示--->
    var detailId = "0"; //set default detailId = 00000001
    console.log("detailId=" + detailId);
    var detailLength = globalStore.jsonForGlobal.detail.length;
    console.log("detailLength=" + detailLength);
    for (var detail = 0; detail < detailLength; detail++) {
      console.log("i=" + detail);
      if (
        globalStore.jsonForGlobal.detail[detail].detailId == this.dataDetailId
      ) {
        this.detailId = detail;
      }
    }
    console.log("detailId=" + this.detailId);
    //////////////////////////////<---查找json里detailId对应的index用于显示End

    ///////////////////////
    //获取History数量-->
    this.historynumber = parseInt(
      globalStore.jsonForGlobal.detail[this.detailId].historyNumber
    );
    /////////////<--

    //////////////////////
    //获取值-->
    this.selectedRequestType =
      globalStore.jsonForGlobal.detail[this.detailId].requestType;
    this.inputedAccount =
      globalStore.jsonForGlobal.detail[this.detailId].account;
    this.inputedDateFrom =
      globalStore.jsonForGlobal.detail[this.detailId].dateFrom;
    this.inputedDateTo = globalStore.jsonForGlobal.detail[this.detailId].dateTo;
    this.selectedCurrency =
      globalStore.jsonForGlobal.detail[this.detailId].currency;
    ///////////////<--获取值

    ////////////////////
    //Show edit or not --->Start
    if (
      globalStore.jsonForGlobal.detail[this.detailId].currentStatus ==
        "Revising" &&
      globalStore.jsonForGlobal.employeeLevel == "1"
    ) {
      //Editable
      this.requestTypeEditable = this.dateFromEditable = this.dateToEditable = this.currencyEditable = this.accountEditable = false;
    } else {
      this.requestTypeEditable = this.dateFromEditable = this.dateToEditable = this.currencyEditable = this.accountEditable = true;
    }
    if (
      (globalStore.jsonForGlobal.detail[this.detailId].currentStatus ==
        "Checking" &&
        globalStore.jsonForGlobal.employeeLevel == "2") ||
      (globalStore.jsonForGlobal.detail[this.detailId].currentStatus ==
        "Pending" &&
        globalStore.jsonForGlobal.employeeLevel == "3")
    ) {
      //feedbackEditable
      this.feedbackEditable = false;
    } else {
      this.feedbackEditable = true;
    }
    ///////////////-----</Show edit or not End

    /////////////get feedback content
    var feedbackContent = "";
    var feedbackDisplayContent = "";
    // "<div style='width:100%;border:1px solid black'>";
    length = globalStore.jsonForGlobal.detail[this.detailId].feedback.length;
    console.log("feedbackLength=" + length);
    for (var feedbackLoop = 0; feedbackLoop < length; feedbackLoop++) {
      feedbackContent =
        // "<p>" +
        globalStore.jsonForGlobal.detail[this.detailId].feedback[feedbackLoop]
          .feedbackContent + "\n";
      // "</p>";
      console.log(feedbackLoop + feedbackContent);

      feedbackDisplayContent += feedbackContent;
    }
    // feedbackDisplayContent += "</div>";
    this.feedbackDisplayContent = feedbackDisplayContent;
    ///////////////////<--Get feedback content end

    //按钮显示不显示-->
    //各ボタン表示/非表示の制御------Start
    //引戻ボタン
    if (
      (globalStore.jsonForGlobal.employeeLevel == "1" &&
        (globalStore.jsonForGlobal.detail[this.detailId].currentStatus ==
          "Checking" ||
          globalStore.jsonForGlobal.detail[this.detailId].currentStatus ==
            "Pending" ||
          globalStore.jsonForGlobal.detail[this.detailId].currentStatus ==
            "Approved")) ||
      (globalStore.jsonForGlobal.employeeLevel == "2" &&
        (globalStore.jsonForGlobal.detail[this.detailId].currentStatus ==
          "Pending" ||
          globalStore.jsonForGlobal.detail[this.detailId].currentStatus ==
            "Approved")) ||
      (globalStore.jsonForGlobal.employeeLevel == "3" &&
        globalStore.jsonForGlobal.detail[this.detailId].currentStatus ==
          "Approved")
    ) {
      this.pullDisplay = true;
    } else {
      this.pullDisplay = false;
    }
    //取下ボタン
    if (
      globalStore.jsonForGlobal.employeeLevel == "1" &&
      globalStore.jsonForGlobal.detail[this.detailId].currentStatus ==
        "Revising"
    ) {
      this.cancelDisplay = true;
    } else {
      this.cancelDisplay = false;
    }
    //保存ボタン
    if (
      (globalStore.jsonForGlobal.employeeLevel == "1" &&
        globalStore.jsonForGlobal.detail[this.detailId].currentStatus ==
          "Revising") ||
      (globalStore.jsonForGlobal.employeeLevel == "2" &&
        globalStore.jsonForGlobal.detail[this.detailId].currentStatus ==
          "Checking") ||
      (globalStore.jsonForGlobal.employeeLevel == "3" &&
        globalStore.jsonForGlobal.detail[this.detailId].currentStatus ==
          "Pending")
    ) {
      this.saveDisplay = true;
    } else {
      this.saveDisplay = false;
    }
    //再申請ボタン
    if (
      globalStore.jsonForGlobal.employeeLevel == "1" &&
      globalStore.jsonForGlobal.detail[this.detailId].currentStatus ==
        "Revising"
    ) {
      this.reviseDisplay = true;
    } else {
      this.reviseDisplay = false;
    }
    //差戻ボタン
    if (
      (globalStore.jsonForGlobal.employeeLevel == "2" &&
        globalStore.jsonForGlobal.detail[this.detailId].currentStatus ==
          "Checking") ||
      (globalStore.jsonForGlobal.employeeLevel == "3" &&
        globalStore.jsonForGlobal.detail[this.detailId].currentStatus ==
          "Pending")
    ) {
      this.sendDisplay = true;
    } else {
      this.sendDisplay = false;
    }
    //承認ボタン/受付ボタン
    if (
      (globalStore.jsonForGlobal.employeeLevel == "3" &&
        globalStore.jsonForGlobal.detail[this.detailId].currentStatus ==
          "Pending") ||
      (globalStore.jsonForGlobal.employeeLevel == "2" &&
        globalStore.jsonForGlobal.detail[this.detailId].currentStatus ==
          "Checking")
    ) {
      this.approvalDisplay = true;
    } else {
      this.approvalDisplay = false;
    }
    //差戻先
    if (
      globalStore.jsonForGlobal.employeeLevel == "3" &&
      globalStore.jsonForGlobal.detail[this.detailId].requestCategory ==
        "External Request" &&
      globalStore.jsonForGlobal.detail[this.detailId].currentStatus == "Pending"
    ) {
      this.returnDisplay = true;
    } else {
      this.returnDisplay = false;
    }
    console.log("pullDisplay=" + this.pullDisplay);
    console.log("cancelDisplay=" + this.cancelDisplay);
    console.log("saveDisplay=" + this.saveDisplay);
    console.log("reviseDisplay=" + this.reviseDisplay);
    console.log("sendDisplay=" + this.sendDisplay);
    console.log("approvalDisplay=" + this.approvalDisplay);
    console.log("returnDisplay=" + this.returnDisplay);
    //按钮显示不显示<--End
    ////////////////////////////显示History-->

    ////////////////////////////<--显示History
  },
  watch: {
    // historynumber(val) {
    //   if (this.e1 > val) {
    //     this.e1 = val;
    //   }
    // }
  },

  methods: {
    switchPageFromComponent(pageName, employeeIdFromLogin, detailId, returnTo, returnToTab) {
      this.$emit(
        "switchPageFromComponent",
        pageName,
        employeeIdFromLogin,
        detailId,
        returnTo,
        returnToTab,
      );
    },
    historyBtn() {
      this.historyShow = !this.historyShow;
      if (this.historyBtnText == "History+") {
        this.historyBtnText = "History-";
        console.log("History-");
      } else {
        this.historyBtnText = "History+";
        console.log("History+");
      }
    },
    saveBtn(pageName, employeeIdFromLogin, detailId, returnTo, returnToTab) {
      alert("Saved");
      // this.$emit(
      //   "switchPageFromComponent",
      //   pageName,
      //   employeeIdFromLogin,
      //   detailId,
      //   returnTo,
      //   returnToTab,
      // );
    },
    pullBtn(pageName, employeeIdFromLogin, detailId, returnTo, returnToTab) {
      alert("Pulled Back");
      this.$emit(
        "switchPageFromComponent",
        pageName,
        employeeIdFromLogin,
        detailId,
        returnTo,
        returnToTab,
      );
    },
    cancelBtn(pageName, employeeIdFromLogin, detailId, returnTo, returnToTab) {
      alert("Cancelled");
      this.$emit(
        "switchPageFromComponent",
        pageName,
        employeeIdFromLogin,
        detailId,
        returnTo,
        returnToTab,
      );
    },
    reviseBtn(pageName, employeeIdFromLogin, detailId, returnTo, returnToTab) {
      alert("Revised");
      this.$emit(
        "switchPageFromComponent",
        pageName,
        employeeIdFromLogin,
        detailId,
        returnTo,
        returnToTab,
      );
    },
    sendBtn(pageName, employeeIdFromLogin, detailId, returnTo, returnToTab) {
      alert("Sent Back");
      this.$emit(
        "switchPageFromComponent",
        pageName,
        employeeIdFromLogin,
        detailId,
        returnTo,
        returnToTab,
      );
    },
    approvalBtn(pageName, employeeIdFromLogin, detailId, returnTo, returnToTab) {
      alert("Approved");
      this.$emit(
        "switchPageFromComponent",
        pageName,
        employeeIdFromLogin,
        detailId,
        returnTo,
        returnToTab,
      );
    }
    // onInput(val) {
    //   this.steps = parseInt(val);
    // },
    // nextStep(n) {
    //   if (n === this.steps) {
    //     this.e1 = 1;
    //   } else {
    //     this.e1 = n + 1;
    //   }
    // }
  }
};
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
