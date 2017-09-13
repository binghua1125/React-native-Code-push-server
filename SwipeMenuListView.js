'use strict';
var {PropTypes} = require('react');
var {requireNativeComponent,View} = require('react-native');
var iface = {
	name : 'SwipeMenuListView',
	propTypes :{
		array : PropTypes.arrayOf(PropTypes.string),
		...View.propTypes,
	},
};
module.exports = requireNativeComponent('SwipeMenuListView',iface);