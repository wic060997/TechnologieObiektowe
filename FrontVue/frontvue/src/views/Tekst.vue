<template>
    <div class="textArea">
      <p>Lorem gipsum text</p>
      <div id="text" v-html="plik"></div>
    </div>
</template>

<script>
import pliczek from '../assets/data/text.json';

export default {
  mounted() {
    console.warn(`Stop:${Date.now()}`);
  },
  name: 'Tekst',

  data() {
    return {
      plik: null,
      abc: null,
    };
  },
  created() {
    this.plik = pliczek.Text;
  },
};
</script>

<style lang="scss">
  #text {
    word-wrap: break-word;
  }
</style>
