<template>
  <div class="music-bar">
    <el-button id="bbtn" @click="show = !show">Click Me</el-button>
    <transition name="el-zoom-in-bottom">
      <div v-show="show" class="transition-box">
        <!-- <aplayer  :audio="musicdata" /> -->
            <aplayer :audio="musicdata" :lrcType="3" />  
           
      </div>
    </transition>
  </div>
</template>
<script src="https://cdn.jsdelivr.net/npm/colorthief@2.0.2/src/color-thief.js"></script>
<script>
//<vue 可以快速调用vuxex插件模板
// 使用了别人写的音乐Audio插件
// 网址：https://github.com/SevenOutman/vue-aplayer/blob/develop/docs/README.zh-CN.md
//2020.12.27更换使用vue-aplayer
//https://aplayer.netlify.app/docs/guide/#%E4%BC%A0%E7%BB%9F%E6%96%B9%E5%BC%8F
//npm install @moefe/vue-aplayer --save
import  APlayer  from '@moefe/vue-aplayer';

export default {
  components: { APlayer },
  name: "music-bar",
  props:['musicdata'],
  data() {
    return {
      show: true,
    };
  },
};
</script>
<style scope>
#bbtn {
  display: block;
}
.transition-box {
  margin-bottom: 10px;
  width: 100%;
  height: 100px;
  border-radius: 4px;
  background-color: #409eff;
  text-align: center;
  color: #fff;
  padding: 40px 20px;
  box-sizing: border-box;
  margin-right: 20px;
}
.music-bar {
  position: fixed;
  bottom: 0px;
  width: 100%;
}
</style>