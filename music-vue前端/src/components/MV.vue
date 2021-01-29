<template>
  <div class="mvs">
    <!-- <h3 class="title">推荐MV</h3> -->
    <div class="items">
      <div class="item" v-for="(item, index) in List" :key="index">
        <div class="img-wrap">
          <img :src="item.picUrl" alt="" />
          <span class="iconfont icon-play ">
              <img src="../assets/icons/play.png" alt="">
          </span>
          <div class="num-wrap">
            <div class="iconfont icon-play">
            </div>
            <div class="num">{{ item.playCount }}</div>
          </div>
        </div>
        <div class="info-wrap">
          <div class="name">{{ item.name }}</div>
          <div class="singer">{{item.artistName}}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      List: [],
    };
  },
  created() {
    axios({
      url: "https://autumnfish.cn/personalized/mv",
      method: "get",
    }).then((res) => {
      console.log(res);
      this.List = res.data.result;
    });
  },
};
</script>

<style scope>

 .mvs .items {
    width: 80%;
  display: flex;
  justify-content: space-around;
  margin: auto;
    flex-wrap: wrap;
}
.mvs .items .item {
  width: 250px;
  /* cursor: pointer; */
}

.mvs .items .item .img-wrap {
  width: 100%;
  position: relative;
  cursor: pointer;
}

.mvs .items .item .img-wrap > .icon-play {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 40px;
  height: 40px;
  color: #dd6d60;
  font-size: 20px;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  background: rgba(255, 255, 255, 0.8);
  opacity: 0;
  transition: all 0.5s ease-in-out;
}
.mvs .items .item .img-wrap > .myplay{
    position: absolute
}
.mvs .items .item .img-wrap > .icon-play::before {
    
  transform: translateX(3px);
}

.mvs .items .item .img-wrap:hover > .icon-play {
  opacity: 1;
}

.mvs .items .item .img-wrap img {
  width: 100%;
  border-radius: 5px;
}

.mvs .items .item .img-wrap .num-wrap {
  position: absolute;
  color: white;
  top: 0;
  right: 0;
  display: flex;
  align-content: center;
  font-size: 15px;
  padding-right: 5px;
  padding-top: 2px;
}

.mvs .items .item .img-wrap .num-wrap .icon-play {
  font-size: 14px;
  display: flex;
  align-items: center;
  margin-right: 5px;
}

.mvs .items .item .info-wrap .name {
  font-size: 15px;
  margin-bottom: 10px;
  height: 30px;
  text-overflow:ellipsis;
}

.mvs .items .item .info-wrap .singer {
  font-size: 14px;
  color: #c5c5c5;
}
</style>