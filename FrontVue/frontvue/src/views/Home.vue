<template>
  <div class="home">
    <div class="selector">
      <router-link to="/text" ><!--v-on:click.native="startTime()">-->
        Tekst
      </router-link>
      <router-link to="/table">Tabela</router-link>
    </div>

  </div>
</template>

<script>
export default {
  name: 'Home',
  destroyed() {
    console.warn(`Start:${Date.now()}`);
  },
  // methods: {
  //   // startTime() {
  //   //   console.warn(`Start:${Date.now()}`);
  //   // },
  // },
};
</script>
