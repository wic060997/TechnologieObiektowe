<template>
    <div class="StaticTable">
      <p>Lorem gipsum Static Table</p>
    </div>
</template>

<script>
export default {
  mounted() {
    console.warn(`Stop:${Date.now()}`);
  },
  name: 'StaticTable',
};
</script>
