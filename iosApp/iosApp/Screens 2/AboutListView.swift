//
//  AboutListView.swift
//  iosApp
//
//  Created by Petros Efthymiou on 23/11/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import shared
import SwiftUI

struct AboutListView: View {
  private struct RowItem: Hashable {
    let title: String
    let subtitle: String
  }


  var body: some View {
      Text("Hello")
        .font(.body)
        .foregroundStyle(.primary)
  }
}

#Preview {
    AboutListView()
}
