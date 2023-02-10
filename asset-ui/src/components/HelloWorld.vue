<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h4>{{ divMsg }}</h4>
  </div>

  <form id="assets" action="http://localhost:8081/getAssetsAndGetMoney/text" method="get" target="myframe">
    <ul>
      <li>
        <label for="initAssets">投资金额:</label>
        <input type="double" id="initAssets" name="initAssets">
      </li>
      <li>
        <label for="n">投资时长:</label>
        <input type="int" id="n" name="n">
      </li>
      <li>
        <label for="rate">期望复利:</label>
        <input type="double" id="rate" name="rate">
      </li>
      <li>
        <button>进行测算</button>
      </li>
    </ul>
  </form>
  <iframe name="myframe" width="600" height="400"></iframe>

</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: '欢迎使用本投资工具来测试养老金！',
      divMsg:'本投资工具为返利投资，每年返利金额为当年投资金额的6%'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
