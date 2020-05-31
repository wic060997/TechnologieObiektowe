<template>
    <div class="dynamic-table">
      <p>Lorem gipsum Dynamic Table 10k Data</p>
    </div>
</template>

<script>
export default {
  mounted() {
    console.warn(`Stop:${Date.now()}`);
  },
  name: 'DynamicTable10k',
};
</script>
