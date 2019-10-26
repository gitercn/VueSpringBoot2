<template>
  <div class="mdui-container">
    <div
      class="mdui-typo-subheading"
      style="width: 100%; margin-top: 8%; margin-bottom: 3%; margin-left: 1%; text-align: left; "
    >
      Requester:
      {{json.employeeId }}{{json.employeeName }}
    </div>
    <!-- <div class="mdui-typo-subheading" style="width: 90%; float: right;">Requester: {{json.employeeId }}{{json.employeeName }}</div> -->
    <table style="width:100%">
      <tr>
        <td style="width:40%">
          <div class="mdui-typo-subheading" style="width: 100%; margin-top: 5%;">
            Expense Type:
            <span style="color:#FF0000">*</span>
          </div>
        </td>
        <td style="width:60%">
          <select class="mdui-select" id="demo-js" style="width: 100%;">
            <option value="1">Internal</option>
            <option value="2">External</option>
          </select>
        </td>
      </tr>
      <tr>
        <td style="width:35%">
          <div class="mdui-typo-subheading" style="width: 100%; margin-top: 5%;">
            Date From:
            <span style="color:#FF0000">*</span>
          </div>
        </td>
        <td style="width:65%">
          <input id="date" class="mdui-select" style="width: 100%;" type="date">
          <!-- 		<mu-col class="mdui-select" id="demo-js" style="width: 100%;" span="12" lg="4" sm="6">
						<mu-date-input v-model="value2" label="Date" label-float="false" full-width no-display></mu-date-input>
          </mu-col>-->
        </td>
      </tr>

      <tr>
        <td style="width:35%">
          <div class="mdui-typo-subheading" style="width: 100%; margin-top: 5%;">
            Date To:
            <span style="color:#FF0000">*</span>
          </div>
        </td>
        <td style="width:65%">
          <input id="date" class="mdui-select" style="width: 100%;" type="date">
        </td>
      </tr>

      <tr>
        <td style="width:35%">
          <div class="mdui-typo-subheading" style="width: 100%; margin-top: 5%;">
            Currency:
            <span style="color:#FF0000">*</span>
          </div>
        </td>
        <td style="width:65%">
          <select class="mdui-select" id="demo-js" style="width: 100%;">
            <option value="1">Japanese Yen (JPY)</option>
            <option value="2">Chinese Yuan Renminbi (CNY)</option>
            <option value="3">United States Dollar (USD)</option>
          </select>
        </td>
      </tr>

      <tr>
        <td style="width:35%">
          <div class="mdui-typo-subheading" style="width: 100%; margin-top: 10%;">
            Account:
            <span style="color:#FF0000">*</span>
          </div>
        </td>
        <td style="width:65%">
          <div class="mdui-textfield">
            <input class="mdui-textfield-input" type="number" placeholder="0">
          </div>
        </td>
      </tr>
    </table>
    <div>
      <p id="p">
        Attach Receipt(8M or smaller)：
        <!-- <span id="takepicture_1">
          <input class="btn" id="takepicture" type="file" v-on:change="setImagePreview();">
        </span>-->
      </p>
    </div>
    <!-- <div id="attach" style="margin-bottom:10px">
      <input style="width:100%; height:160px" data-options="labelPosition:'top'">
    </div>
    <div class="images" id="localImag">
      <img id="preview" width="-1" height="-1" style="display: none" @click="toggle()">
    </div>-->
    <div id="dynamic_create">
      <!-- <mt-field  v-model="dynamicContent" placeholder="发表您的动态" type="textarea" rows="4" ></mt-field> -->
      <uploader @getFiles="getImageList" @removeFiles="removeImage"></uploader>
      <!-- <div class="btn-wrapper">
        <mt-button class='btn-send' size="large" type="primary" @click="send">发布</mt-button>
      </div>-->
    </div>
    <div>
      <div style="float:left">
        <a
          id="btn"
          class="mdui-btn mdui-btn-raised"
          style="width:80px"
          v-on:click="switchPageFromComponent('home','')"
        >Cancel</a>
        <!-- <button class="mdui-btn mdui-btn-raised">Button</button> -->
      </div>
      <div style="float:right">
        <a
          onClick="alert('Submitted')"
          class="mdui-btn mdui-btn-raised"
          style="width:80px"
          v-on:click="switchPageFromComponent('home','')"
        >Submit</a>
      </div>
    </div>
  </div>
</template>



<script>
import mdui from "mdui";
import { globalStore } from "./globalStore.js";

import { Indicator, Toast } from "mint-ui";
import uploader from "./Upload";

var inst = new mdui.Select("#demo-js");
// /////////////上传图片-->
// var flag = true,
//   imgH, //图片的高度
//   imgW, //图片的宽度
//   img = document.getElementsByTagName("img")[0]; //图片元素
// ////////////////////<--上传图片End
export default {
  data() {
    return {
      // json: this.GLOBAL2.jsonForGlobal, //直接通过this访问全局变量。
      json: globalStore.jsonForGlobal,
      // isActive: true
      dynamicContent: "", //动态内容
      imgList: [], //已上传的图片集合
      FilecodeList: [],
      isSubmit: false
    };
  },
  name: "DynamicCreate",
  // 上传图片
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
    ///////
    getImageList(files) {
      this.$nextTick(() => {
        for (let i = 0, len = files.length; i < len; i++) {
          this.imgList.push(files[i].src.split("base64,")[1]);
          //上传图片
          //   this._getFileCode({
          //     Base64Str: files[i].src.split("base64,")[1],
          //     AttachmentType: this.$enums.AttachmentType.Activity
          //   });
        }
      });
    },
    //删除图片
    removeImage(index) {
      this.imgList.splice(index, 1);
    },

    //上传图片获取fileCode (目前该方法没调用，供参考)
    _getFileCode(obj) {
      // Indicator.open(this.lang.dynamic_publishing);
      this.$http
        .post(this.$profileApi.Shared_UploadImage, obj)
        .then(data => {
          if (data.Rstatus) {
            this.FilecodeList.push(data.Rdata);
          } else {
            // Toast(this.lang.dynamic_upload_fail);
          }
        })
        .catch(err => {
          //   Toast(this.lang.dynamic.dynamic_net_error);
        });
    },

    //创建动态 (发布动态的请求)
    createDynamic(arr) {
      this.isSubmit = true;
      this.$http
        .post(this.$profileApi.Dynamic_CreateDynamic, {
          Subject: this.dynamicContent,
          Files: arr
        })
        .then(data => {
          this.isSubmit = false;
          if (data.Rstatus) {
            // Toast(this.lang.dynamic_publish_ok);
            this.$router.back();
          } else {
            // Toast(this.lang.dynamic_publish_fail);
          }
        })
        .catch(err => {
          //   Toast(this.lang.dynamic_net_error);
        });
    },

    //发布事件
    send() {
      Toast("提交信息在控制台里～图片地址是压缩后的base64地址");
      console.log("内容" + this.dynamicContent);
      console.log(this.imgList);

      //   if (this.dynamicContent.trim() == "" && this.imgList.length === 0) {
      //     // Toast(this.lang.dynamic_content_no_null);
      //     return;
      //   }
      //   //当图片还没上传成功
      //   let self = this;
      //   var timer = setInterval(function() {
      //     if (
      //       self.FilecodeList &&
      //       self.imgList &&
      //       self.FilecodeList.length < self.imgList.length
      //     ) {
      //       // Indicator.open(self.lang.dynamic_uploading)
      //       self.isSubmit = true;
      //     } else {
      //       clearInterval(timer);
      //       // Indicator.close();
      //       self.createDynamic(self.FilecodeList);
      //     }
      //   }, 200);
    }
    // //点击图片放大缩小
    // toggle() {
    //   this.isActive = !this.isActive;
    //   //状态true为正常的状态,false为放大的状态

    //   if (flag) {
    //     // console.log("big");
    //     flag = false;
    //     var preview = document.getElementById("preview");
    //     var w = document.body.clientWidth;
    //     var h = document.body.clientHeight;
    //     preview.style.width = w + "px";
    //     preview.style.height = (3 / 4) * w + "px";
    //   } else {
    //     flag = true;
    //     // console.log("small");
    //     var preview = document.getElementById("preview");
    //     var w = document.body.clientWidth;
    //     var h = document.body.clientHeight;
    //     preview.style.width = "160px";
    //     preview.style.height = "120px";
    //   }
    // },
    // //上传图片
    // setImagePreview() {
    //   document.getElementById("attach").style.display = "none";
    //   var preview,
    //     img_txt,
    //     localImag,
    //     takepicture = document.getElementById("takepicture"),
    //     picture = takepicture.value;
    //   var max_size = 6144; // 6M
    //   var fileData = takepicture.files[0];
    //   var size = fileData.size;

    //   if (!picture.match(/.jpg|.png|.bmp/i))
    //     return (
    //       alert(
    //         "The image you uploaded is not in the correct format. Please re-select it."
    //       ),
    //       !1
    //     );
    //   if (size > max_size * 1024) {
    //     return alert("Don't upload image above 6M"), !1;
    //   }
    //   if (
    //     ((preview = document.getElementById("preview")),
    //     takepicture.files && takepicture.files[0])
    //   )
    //     (preview.style.display = "block"),
    //       (preview.style.width = "160px"),
    //       (preview.style.height = "120px"),
    //       (preview.src = window.URL.createObjectURL(takepicture.files[0]));
    //   else {
    //     takepicture.select(),
    //       takepicture.blur(),
    //       (img_txt = document.selection.createRange().text),
    //       (localImag = document.getElementById("localImag")),
    //       (localImag.style.width = "160px"),
    //       (localImag.style.height = "120px");
    //     try {
    //       (localImag.style.filter =
    //         "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)"),
    //         (localImag.filters.item(
    //           "DXImageTransform.Microsoft.AlphaImageLoader"
    //         ).src = img_txt);
    //     } catch (f) {
    //       return (
    //         alert(
    //           "The image you uploaded is not in the correct format. Please re-select it."
    //         ),
    //         !1
    //       );
    //     }
    //     (preview.style.display = "none"), document.selection.empty();
    //   }
    // }
  },
  components: {
    uploader
  }
};
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.mdui-ripple btn {
  margin-top: 15%;
  width: 30%;
}

/* input[type="date"]::-webkit-calendar-picker-indicator {
		display: none;
	}

	input[type="date"]::-webkit-clear-button {
		display: none;
	} */
</style>
<style lang="less" scoped>
.mdui-ripple btn {
  margin-top: 15%;
  width: 30%;
}
//发布动态
#dynamic_create {
  height: 23vh;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  background: #fff;
}
#dynamic_create canvas {
  background: #000 !important;
}
.btn-send {
  margin: 22px;
  display: block;
  width: 100%;
}
.btn-wrapper {
  display: flex;
}
#dynamic_create .mint-cell {
  border: none;
}
</style>