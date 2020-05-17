<template>
    <div class="textArea">
      <p>Lorem gipsum text</p>
      <div >{{textSample}}</div>
    </div>
</template>

<script>
export default {
  mounted() {
    console.log(`Stop:${Date.now()}`);
  },
  name: 'Text',
  textSample: 'Abcd efgh ijkl',
};
</script>
