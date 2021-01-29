<template>
<div class="result">
  <!-- 标签栏 -->
   <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="单曲" name="first">单曲</el-tab-pane>
    <el-tab-pane label="歌手" name="second">歌手</el-tab-pane>
    <el-tab-pane label="歌单" name="third">歌单</el-tab-pane>
    <el-tab-pane label="MV" name="fourth">MV</el-tab-pane>
  </el-tabs>
  <!-- 分页 -->
  <el-pagination
  background
  layout="prev, pager, next"
  :total="1000">
</el-pagination>
<!-- 2020.12.25 -->
    <div>我是搜索结果</div>
</div>
</template>

<script>
export default {
  data() {
    return {
      activeName:'second'
    }
  },
  methods: {
      handleClick(tab, event) {
        console.log(tab, event);
      }
    },
created() {
  console.log(this.$route)
},
}
</script>

<style>

</style>