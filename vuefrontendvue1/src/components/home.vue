<template>
  <div class="home">
    <!-- <div v-for="(block,index) in employeeId" :key="index">
      <div></div>
      <div>{{block }}</div>
    </div>-->
    <!-- 引入大图 -->
    <!-- <v-app> -->
    <div style="padding:5px"></div>
    <img class="bigimg" src="@/assets/picture/5.png">
    <div style="padding:5px"></div>
    <!-- 引入下面的小图 -->
    <div id="boxtop">
      <div class="mdui-ripple lowerDivs">
        <img class="smallimg" src="@/assets/picture/1/1.png">
        <div class="font1">Leave</div>
      </div>
      <div class="mdui-ripple lowerDivs topRight"  v-on:click="switchPageFromComponent('expense','')">
        <img class="smallimg" src="@/assets/picture/1/2.png">
        <div class="font1">Expense</div>
      </div>
    </div>
    <div style="padding:5px"></div>
    <div id="boxbottom">
      <div class="mdui-ripple lowerDivs">
        <img class="smallimg" src="@/assets/picture/1/3.png">
        <div class="font1">Proposal</div>
      </div>
      <div class="mdui-ripple lowerDivs topRight" v-on:click="switchPageFromComponent('expense2','')">
        <img class="smallimg" src="@/assets/picture/1/4.png">
        <div class="font1">Others</div>
      </div>
    </div>
    <!-- </v-app> -->
  </div>

</template>

<script>
export default {
  name: "home",
  methods: {
    switchPageFromComponent(pageName, detailId) {
      console.log(pageName);
      this.$emit("switchPageFromComponent", pageName, detailId);
      toString("hello");
    }
  },
  created: function() {
    this.$emit("header", true);
  }
};
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.bigimg {
  /* height: 100%; */
  width: 100%;
  object-fit: contain;
}

#boxtop {
  padding: 0px;
  margin: 0px;
  width: 100%;
  /* height: 130px; */
  object-fit: contain;
  display:flex;
}

#boxbottom {
  padding: 0px;
  margin: 0px;
  width: 100%;
  /* height: 130px; */
  object-fit: contain;
  display:flex;
}

.topRight {
  margin-left: 2%;
}

.font1 {
  color: #ffffff;
  font-size: 110%;
  /* font-weight:500; */
}

.lowerDivs {
  /* 调整子元素左右居中 */
  text-align: center;
  /* line-height调整上下高度 */
  float: left;
  background: #4dd0e1;
  width: 49%;
  /* height: 95%; */
  border: 1px solid #00bcd4;
  /* object-fit: contain; */
  /* display: table-cell; */
}



.lowerDivs img {
  margin-top: 15%;
  width: 30%;
  /* object-fit: contain; */
}

.smallimg {
}
</style>
