<template>
    <div class="dynamic-table">
      <p>Lorem gipsum Dynamic Table 1m Data</p>
    </div>
</template>

<script>
export default {
  mounted() {
    console.warn(`Stop:${Date.now()}`);
  },
  name: 'DynamicTableSimple',
};
</script>
