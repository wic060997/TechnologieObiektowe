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
            <router-link to='/dynamic-table/data3k' ><!--v-on:click.native='startTime()'>-->
              3k Danych
            </router-link>
            <router-link to='/dynamic-table/data5k' ><!--v-on:click.native='startTime()'>-->
              5k Danych
            </router-link>
            <router-link to='/dynamic-table/data10k' ><!-- v-on:click.native='startTime()'>-->
              10k Danych
            </router-link>
            <router-link to='/dynamic-table/data20k' ><!-- v-on:click.native='startTime()'>-->
              20k Danych
            </router-link>
            <router-link to='/dynamic-table/data50k' ><!-- v-on:click.native='startTime()'>-->
              50k Danych
            </router-link>
            <router-link to='/dynamic-table/data1m' ><!--v-on:click.native='startTime()'>-->
              1m Danych
            </router-link>
            <router-link to='/dynamic-table/data3m' ><!--v-on:click.native='startTime()'>-->
              3m Danych
            </router-link>
            <router-link to='/dynamic-table/data5m' ><!--v-on:click.native='startTime()'>-->
              5m Danych
            </router-link>
            <router-link to='/dynamic-table/data10m' ><!--v-on:click.native='startTime()'>-->
              10m Danych
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
    flex-flow: row wrap;
    align-items: center;
    justify-content: center;
  }
</style>
