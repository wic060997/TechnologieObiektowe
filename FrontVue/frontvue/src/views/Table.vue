<template>
    <div class="table">
        <div class='selector'>
            <router-link to='/static-table' v-on.native='startTime()' v-bind:id="dynamicId">
                Dane w tabeli statyczne
            </router-link>
            <router-link to='/dynamic-table'>Dane z REST API</router-link>
        </div>
    </div>
</template>

<script>
export default {
  name: 'Table',
  methods: {
    startTime() {
      console.warn(`Start:${Date.now()}`);
    },
  },
};
</script>
