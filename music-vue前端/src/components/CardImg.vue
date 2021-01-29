<template>
  <div class="card-img">
    <el-carousel :interval="4000" type="card" height="270px">
      <el-carousel-item v-for="(item, index) in imgs" :key="index">
        <img class="lunbo-img" :src="item.imageUrl" />
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<style scope>
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
.lunbo-img {
  height: 100%;
  width: 100%;
}
.card-img {
  width: 90%;
  margin: auto;
  margin-top: 40px;
}
</style>

<script>
import axios from 'axios'
export default {
  name: "card-img",
  data() {
    return {
      //这边先用写死的图片方便调整
      imgs: [
        { imageUrl: require("../assets/img/01.jpg") },
        { imageUrl: require("../assets/img/02.jpg") },
        { imageUrl: require("../assets/img/03.jpg") },
        { imageUrl: require("../assets/img/04.jpg") },
        { imageUrl: require("../assets/img/05.jpg") },
      ],
    };
  },
  created() {
    axios({
      url:'https://autumnfish.cn/banner',
      method:'get',
      params:{
        type:0
      }
    }).then(res=>{
      console.log(res)
      this.imgs=res.data.banners
    })
  },
};
</script>