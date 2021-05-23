<template>
 <div>
   <div class="head-1" style="background: #1357ac"><img src="../assets/logo.png" border="0"></div>
   <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
     <el-menu-item index="1">网站首页</el-menu-item>
     <el-menu-item index="2">新闻资讯</el-menu-item>
     <el-menu-item index="2">学校概览</el-menu-item>
     <el-menu-item index="2">学院设置</el-menu-item>
     <el-menu-item index="2">管理机构</el-menu-item>
     <el-menu-item index="2">人才师资</el-menu-item>
     <el-menu-item index="2">教育教学</el-menu-item>
     <el-menu-item index="2">科学研究</el-menu-item>
   </el-menu>
   <div>
     <img src="../assets/banner22.jpg" border="0">
   </div>
   <div>
     <div class="left">
      <h3>学校概览</h3>
       <div class="left-list">
         <ul>
           <li><router-link to="homeWebsite">学校简介</router-link></li>
           <li><router-link to="page2">学校章程</router-link></li>
           <li><router-link to="page1">校史追溯</router-link></li>
           <li><a href="#">现任领导</a></li>
           <li><a href="#">校徽校歌</a></li>
           <li><a href="#">重师图库</a></li>
         </ul>
       </div>
     </div>
   </div>




   <div class="right fr">
     <div class="local fl">
      <h3>学校简介</h3>
<!--  <div class="dqwz fr">-->
<!--       当前位置:-->
<!--       <a href="">网站首页</a>-->
<!--       &gt;-->
<!--       <a href="">学校概览</a>-->
<!--       &gt;-->
<!--       <a href="">学校简介</a>-->
<!--     </div>-->
     </div>

     <div class="content">
       <div class="content-title">
         <h3>重庆师范大学简介</h3>
       </div>
       <div class="content-con">
         <div id="vsb_content_2680_1"><div id="vsb_content"><div>
           <p style="text-align: justify">重庆师范大学是中华人民共和国成立后较早建立的高等师范院校之一。1954年1月，西南军政委员会文教部、重庆市人民委员会批准建立重庆师范专科学校。1960年9月，四川省人民委员会批准学校更名为重庆师范学院，同年获得本科专业设置资格。1962年9月，四川省人民委员会按照国家精简压缩的要求，批准学校复名为重庆师范专科学校，同时成都师范专科学校并入。1978年1月，四川省革命委员会批准学校再次更名为重庆师范学院。1981年获得学士学位授予权。1986年获得硕士学位授予权。1997年随重庆市直辖而划归重庆市人民政府管辖。2001年5月，重庆市人民政府批准1914年创建于重庆市渝中区的重庆幼儿师范学校和1970年由国家轻工部举办的重庆纺织职工大学并入。2003年4月，教育部批准学校更名为重庆师范大学，同年9月，重庆市人民政府批准起源于1906年创立的官立川东师范学堂的重庆市第一师范学校并入。2008年经重庆市学位委员会批准成为中期立项建设新增博士单位高校。经过几十年的建设，学校已发展成为以教师教育为特色、多学科协调发展的综合性师范大学。 &nbsp; </p>
         </div></div></div>

       </div>
     </div>
   </div>




 </div>
</template>

<script>
export default {
  name: "HomeWebsite"
}
</script>

<style scoped>

.left {
  width: 235px;
  float: left;
  margin-top: -4px;
  border-top: 6px solid #08448e;
  border-left: 8px solid #e0e0e0;
  margin-bottom: 50px;
  padding-left: 10px;
}






.right {
  width: 900px;
  background: #fff;
  padding-left: 47px;
  margin-top: -5px;
}

.fr {
  float: right;
}
</style>