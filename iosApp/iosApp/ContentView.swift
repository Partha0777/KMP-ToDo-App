// iOSViewModel.swift

import SwiftUI
import Combine
import shared // Import the shared KMP module

// 1. Observable ViewModel class for SwiftUI
class iOSArticleViewModel: ObservableObject {
    private let articleViewModel = ArticleViewModel() // Instance of shared ViewModel
    private var cancellables = Set<AnyCancellable>()
    
    @Published var articleText: String = "" // State variable for the UI
    
    init() {
        // Observe the shared StateFlow using a callback
        observeArticles()
    }
    
    // Function to observe articles from Kotlin's StateFlow
    private func observeArticles() {
        articleViewModel.observeArticles { [weak self] article in
            DispatchQueue.main.async {
                self?.articleText = article
            }
        }
    }
    
    // Function to update articles if needed
    func getArticles() {
        articleViewModel.getArticles() // Call the shared function if needed
    }
    
    deinit {
        // Clean up resources
        cancellables.forEach { $0.cancel() }
    }
}

// 2. SwiftUI View to bind to the ObservableObject
struct ContentView: View {
    @ObservedObject private var viewModel = iOSArticleViewModel() // Bind to the iOS view model
    
    var body: some View {
        VStack {
            Text(viewModel.articleText) // Display the state from the shared ViewModel
                .padding()
            
            Button(action: {
                viewModel.getArticles() // Trigger fetching articles
            }) {
                Text("Fetch Articles")
            }
        }
    }
}

// 3. SwiftUI Preview
struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
