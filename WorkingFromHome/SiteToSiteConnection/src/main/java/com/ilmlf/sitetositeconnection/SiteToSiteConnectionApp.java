/*
Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
Licensed under the Apache License, Version 2.0 (the "License").
You may not use this file except in compliance with the License.
You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.ilmlf.sitetositeconnection;

import software.amazon.awscdk.core.App;
import software.amazon.awscdk.core.Environment;
import software.amazon.awscdk.core.StackProps;

public class SiteToSiteConnectionApp {
  public static void main(final String[] args) {
    App app = new App();

    new SiteToSiteConnectionStack(
        app,
        "SiteToSiteConnectionStack",
        StackProps.builder()
            .env(Environment.builder().account("433621526002").region("eu-west-1").build())
            .description("Site to Site Base infra Stack (uksb-1rsq7leb5)")
            .build());
    app.synth();
  }
}
