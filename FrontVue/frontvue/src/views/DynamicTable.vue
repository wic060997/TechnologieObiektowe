<template>
    <div class="dynamic-table">
      <p v-on:click="startTime()">Lorem gipsum Dynamic Table</p>

      <div class='selector'>
            <router-link to='/dynamic-table/simple' ><!--v-on:click.native='startTime()'>-->
              1 Dana
            </router-link>
            <router-link to='/dynamic-table/data1k' ><!--v-on:click.native='startTime()'>-->
              1k Danych
            </router-link>
            <router-link to='/dynamic-table/data10k' ><!-- v-on:click.native='startTime()'>-->
              10k Danych
            </router-link>
            <router-link to='/dynamic-table/data1m' ><!--v-on:click.native='startTime()'>-->
              1m Danych
            </router-link>
        </div>
    </div>
</template>

<script>
export default {
  methods: {
    startTime() {
      console.warn(`Start:${Date.now()}`);
    },
  },
  destroyed() {
    console.warn(`Start:${Date.now()}`);
  },
  name: 'DynamicTable',
};
</script>

<style lang="scss">
  .selector {
    display: flex;
  }
</style>
