Shopnplot::Application.routes.draw do
  root 'static_pages#home'
  match '/help', to: 'static_pages#help', via: 'get'
  match '/laptops', to: 'static_pages#laptops', via: 'get'
  match '/about', to: 'static_pages#about', via: 'get'
  match '/signup', to: 'users#new', via: 'get'
  match '/cssstyleforsite', to: 'statics_pages#cssstyleforsite', via: 'get'

  match '/AcerAspireV3772G9822', to: 'static_pages#AcerAspireV3772G9822', via: 'get'
  match '/AcerAspireS7S73926803', to: 'static_pages#AcerAspireS7S73926803', via: 'get'
  match '/AcerC7102487', to: 'static_pages#AcerC7102487', via: 'get'
  match '/AcerAspireE15726870', to: 'static_pages#AcerAspireE15726870', via: 'get'
  match '/AcerAspireMM5583P6428', to: 'static_pages#AcerAspireMM5583P6428', via: 'get'
  match '/DellInspiron17i17RV6273BLK', to: 'static_pages#DellInspiron17i17RV6273BLK', via: 'get'
  match '/DellLatitude6430u4693885', to: 'static_pages#DellLatitude6430u4693885', via: 'get'
  match '/DellXPS12ULT', to: 'static_pages#DellXPS12ULT', via: 'get'
  match '/DellInspiron17i17RV5454BLK', to: 'static_pages#DellInspiron17i17RV5454BLK', via: 'get'
  match '/DellLatitudeE64304694216', to: 'static_pages#DellLatitudeE64304694216', via: 'get'
  match '/DellAlienware14ALW142812sLV', to: 'static_pages#DellAlienware14ALW142812sLV', via: 'get'
  match '/DellXPS15XPS1511047sLV', to: 'static_pages#DellXPS15XPS1511047sLV', via: 'get'
  match '/DellAlienware18ALW183002sLV', to: 'static_pages#DellAlienware18ALW183002sLV', via: 'get'
  match '/AsusN550JVDB71', to: 'static_pages#AsusN550JVDB71', via: 'get'
  match '/AsusX550CADB31', to: 'static_pages#AsusX550CADB31', via: 'get'
  match '/AsusG75SeriesG750JXDB71', to: 'static_pages#AsusG75SeriesG750JXDB71', via: 'get'
  match '/HPZBook15F2P51UTABA', to: 'static_pages#HPZBook15F2P51UTABA', via: 'get'
  match '/HPPavilionG62210US', to: 'static_pages#HPPavilionG62210US', via: 'get'
  match '/HPPavilion14q070nr', to: 'static_pages#HPPavilion14q070nr', via: 'get'
  match '/HPEliteBookFolio9470mE1Y62UTABA', to: 'static_pages#HPEliteBookFolio9470mE1Y62UTABA', via: 'get'
  match '/HPSpectre15T4000', to: 'static_pages#HPSpectre15T4000', via: 'get'
  match '/LenovoIdeaPadYoga1359359564', to: 'static_pages#LenovoIdeaPadYoga1359359564', via: 'get'
  match '/ThinkPadX240', to: 'static_pages#ThinkPadX240', via: 'get'
  match '/LenovoIdeaPadY510P59375624', to: 'static_pages#LenovoIdeaPadY510P59375624', via: 'get'
  match '/ThinkPadT440s', to: 'static_pages#ThinkPadT440s', via: 'get'
  match '/LenovoIdeaPadU31059365302', to: 'static_pages#LenovoIdeaPadU31059365302', via: 'get'
  match '/LenovoThinkPadX1Carbon3444B9U', to: 'static_pages#LenovoThinkPadX1Carbon3444B9U', via: 'get'
  match '/ThinkPadEdgeE43162775AU', to: 'static_pages#ThinkPadEdgeE43162775AU', via: 'get'
  match '/LenovoIdeaPadU31059365302', to: 'static_pages#LenovoIdeaPadU31059365302', via: 'get'
  match '/SamsungATIVBook9PlusNP940X3GK01US', to: 'static_pages#SamsungATIVBook9PlusNP940X3GK01US', via: 'get'
  match '/SamsungATIVBook5NP540U4EK03US', to: 'static_pages#SamsungATIVBook5NP540U4EK03US', via: 'get'
  match '/SamsungATIVBook9NP940X3GK04US', to: 'static_pages#SamsungATIVBook9NP940X3GK04US', via: 'get'
  match '/SamsungATIVBook6NP680Z5EX01US', to: 'static_pages#SamsungATIVBook6NP680Z5EX01US', via: 'get'
  match '/SamsungXE303C12A01US', to: 'static_pages#SamsungXE303C12A01US', via: 'get'
  match '/ToshibaQosmioX75A7295', to: 'static_pages#ToshibaQosmioX75A7295', via: 'get'
  match '/ToshibaSatelliteL55DtA5253NR', to: 'static_pages#ToshibaSatelliteL55DtA5253NR', via: 'get'
  match '/ToshibaQosmioX875Q7390', to: 'static_pages#ToshibaQosmioX875Q7390', via: 'get'
  match '/ToshibaSatelliteU845tS4165', to: 'static_pages#ToshibaSatelliteU845tS4165', via: 'get'
  match '/AppleMacBookProMC975LLA', to: 'static_pages#AppleMacBookProMC975LLA', via: 'get'
  match '/AppleMacBookProMD101LLA', to: 'static_pages#AppleMacBookProMD101LLA', via: 'get'
  match '/AppleMacBookProMC976LLA', to: 'static_pages#AppleMacBookProMC976LLA', via: 'get'
  match '/AppleMacBookProwithRetinaDisplayME866LLA', to: 'static_pages#AppleMacBookProwithRetinaDisplayME866LLA', via: 'get'
  match '/AppleMacBookProwithRetinaDisplayME865LLA', to: 'static_pages#AppleMacBookProwithRetinaDisplayME865LLA', via: 'get'
  match '/AppleMacBookProwithRetinaDisplayME294LLA', to: 'static_pages#AppleMacBookProwithRetinaDisplayME294LLA', via: 'get'
  match '/AppleMacBookAirMD761LLA', to: 'static_pages#AppleMacBookAirMD761LLA', via: 'get'
  match '/AppleMacBookProwithRetinaDisplayME864LLA', to: 'static_pages#AppleMacBookProwithRetinaDisplayME864LLA', via: 'get'
  match '/AppleMacBookAirMD711LLA', to: 'static_pages#AppleMacBookAirMD711LLA', via: 'get'
  match '/AppleMacBookAirMD712LLA', to: 'static_pages#AppleMacBookAirMD712LLA', via: 'get'
  match '/AppleMacBookProwithRetinaDisplayME293LLA', to: 'static_pages#AppleMacBookProwithRetinaDisplayME293LLA', via: 'get'
  match '/AppleMacBookProME662LLA', to: 'static_pages#AppleMacBookProME662LLA', via: 'get'
  match '/AppleMacBookAirMD760LLA', to: 'static_pages#AppleMacBookAirMD760LLA', via: 'get'
  match '/AppleMacBookProME665LLA', to: 'static_pages#AppleMacBookProME665LLA', via: 'get'
  match '/AppleMacBookProME664LLA', to: 'static_pages#AppleMacBookProME664LLA', via: 'get'




  # The priority is based upon order of creation: first created -> highest priority.
  # See how all your routes lay out with "rake routes".

  # You can have the root of your site routed with "root"
  # root 'welcome#index'

  # Example of regular route:
  #   get 'products/:id' => 'catalog#view'

  # Example of named route that can be invoked with purchase_url(id: product.id)
  #   get 'products/:id/purchase' => 'catalog#purchase', as: :purchase

  # Example resource route (maps HTTP verbs to controller actions automatically):
  #   resources :products

  # Example resource route with options:
  #   resources :products do
  #     member do
  #       get 'short'
  #       post 'toggle'
  #     end
  #
  #     collection do
  #       get 'sold'
  #     end
  #   end

  # Example resource route with sub-resources:
  #   resources :products do
  #     resources :comments, :sales
  #     resource :seller
  #   end

  # Example resource route with more complex sub-resources:
  #   resources :products do
  #     resources :comments
  #     resources :sales do
  #       get 'recent', on: :collection
  #     end
  #   end

  # Example resource route with concerns:
  #   concern :toggleable do
  #     post 'toggle'
  #   end
  #   resources :posts, concerns: :toggleable
  #   resources :photos, concerns: :toggleable

  # Example resource route within a namespace:
  #   namespace :admin do
  #     # Directs /admin/products/* to Admin::ProductsController
  #     # (app/controllers/admin/products_controller.rb)
  #     resources :products
  #   end
end
