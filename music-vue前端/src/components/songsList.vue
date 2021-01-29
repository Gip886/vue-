<template>
  <div class="recommend">
    <!-- <h3 class="title">推荐歌单</h3> -->
    <div class="items">
      <div class="item" v-for="(item, index) in list" :key="index">
        <div class="img-wrap">
          <div class="desc-wrap">
            <span class="desc">{{ item.copywriter }}</span>
          </div>
          <img :src="item.picUrl" alt="" />
          <div class="bofang">
            <el-button icon="el-icon-video-play" type="info"
              >点击播放</el-button
            >
          </div>
        </div>
        <p class="name">{{ item.name }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      list: [],
    };
  },
  created() {
    axios({
      url: "https://autumnfish.cn/personalized",
      method: "get",
      params: {
        limit: 12,
      },
    }).then((res) => {
      // console.log(res)
      this.list = res.data.result;
    });
  },
};
</script>

<style scope>
* {
  margin: 0;
  padding: 0;
  border: 0px;
}
.recommend {
  width: 80%;
  margin: auto;
  position: relative;
}
.recommend .items {
  width: 100%;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: center;
}
.recommend .items .item {
  width: 250px;
  margin: auto;
  margin-top: 10px;
}

.item .desc-wrap {
  width: 100%;
  height: 40px;
  text-align: left;
  background: #e0f3f8;
  position: relative;
  overflow: hidden;
  top: 0;
  opacity: 0;
  transition: all 1s ease-in-out;
}
.item .desc-wrap .desc {
  width: 100%;
  font-size: 15px;
  position: absolute;
  text-overflow: ellipsis;
}
.img-wrap {
  position: relative;
}
.img-wrap img {
  width: 100%;
}
.item:hover .desc-wrap {
  top: 40px;
  opacity: 0.8;
}
.item .name {
  text-align: start;
  font-size: 16px;
}
.item .bofang {
  position: absolute;
  bottom: 4px;
  right: 0px;
  opacity: 0;
  visibility: hidden;
  transition: all 1s ease-in-out;
}
.item:hover .bofang {
  visibility: visible;
  opacity: 0.8;
}
</style>