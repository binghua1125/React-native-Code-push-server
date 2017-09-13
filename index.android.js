/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  Dimensions,
  TouchableOpacity
} from 'react-native';
import codePush from "react-native-code-push";

let codePushOptions = {checkFrequency: codePush.CheckFrequency.MANUAL};

var SwipeMenuListView = require('./SwipeMenuListView');
export default class Demo2 extends Component {
	onButtonPress() {
		codePush.sync({
			updateDialog: true,
			installMode: codePush.InstallMode.IMMEDIATE
		});
	}
  render() {
    return (
      <View>
	  <TouchableOpacity onPress={this.onButtonPress}>
	  <Text>Check for updates annnnn</Text>
	  </TouchableOpacity>
	  <SwipeMenuListView style={styles.listView} array={["Java", "C", "C++", "C#", "Python", "PHP"
	  , "Visual Basic .NET", "JavaScript", "Assembly Language", "Ruby", "Perl"
	  , "Delphi", "Visual Basic", "Swift", "MATLAB", "Pascal"]}>
	  </SwipeMenuListView>
	  </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  listView: {
    width: Dimensions.get('window').width,
    height: Dimensions.get('window').height,
  },
});

Demo2 = codePush(codePushOptions)(Demo2)
AppRegistry.registerComponent('Demo2', () => Demo2);
