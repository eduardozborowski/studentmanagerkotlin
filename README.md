# 📚 Cadastro de Alunos e Pagamentos

Bem-vindo ao projeto **Cadastro de Alunos e Pagamentos**, um aplicativo Android que permite gerenciar alunos e seus pagamentos de forma intuitiva e eficiente. Este aplicativo foi desenvolvido utilizando as melhores práticas do Android, incluindo Room Database, MVVM, Navigation Component e muito mais.

## Índice

- [🎯 Objetivo do Projeto](#-objetivo-do-projeto)
- [🛠️ Funcionalidades](#️-funcionalidades)
- [📱 Capturas de Tela](#-capturas-de-tela)
- [🚀 Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [🚚 Como Usar](#-como-usar)
  - [Cadastro de Aluno](#cadastro-de-aluno)
  - [Listagem de Alunos](#listagem-de-alunos)
  - [Cadastro de Pagamento](#cadastro-de-pagamento)
  - [Listagem de Pagamentos](#listagem-de-pagamentos)
- [📄 Licença](#-licença)
- [👥 Contribuição](#-contribuição)
- [📞 Contato](#-contato)

---

## 🎯 Objetivo do Projeto

O objetivo deste projeto é criar um aplicativo Android que permita:

- Cadastrar alunos com informações pessoais e acadêmicas.
- Capturar e armazenar a foto do aluno usando a câmera do dispositivo.
- Gerenciar pagamentos associados a cada aluno.
- Realizar operações CRUD (Create, Read, Update, Delete) tanto para alunos quanto para pagamentos.
- Exibir listas de alunos e pagamentos utilizando RecyclerView.
- Navegar entre diferentes telas de forma intuitiva utilizando o Navigation Component.

---

## 🛠️ Funcionalidades

- **Cadastro de Alunos**: Inclua nome, CPF, telefone, foto, status (Ativo/Inativo) e tipo de curso (Graduação/Pós-Graduação).
- **Captura de Foto**: Tire fotos dos alunos usando a câmera e armazene no banco de dados.
- **Listagem de Alunos**: Visualize todos os alunos cadastrados em uma lista.
- **Edição e Exclusão de Alunos**: Atualize ou remova alunos existentes.
- **Cadastro de Pagamentos**: Registre pagamentos associados a alunos, incluindo valor e data.
- **Listagem de Pagamentos**: Visualize todos os pagamentos de um aluno específico.
- **Edição e Exclusão de Pagamentos**: Atualize ou remova pagamentos existentes.
- **Persistência de Dados**: Utilize Room Database para armazenar dados localmente.
- **Arquitetura MVVM**: Mantenha um código organizado e de fácil manutenção.
- **Navegação Intuitiva**: Use o Navigation Component para navegar entre as telas.

---

## 📱 Capturas de Tela

*Nota: Como este é um documento de texto, as capturas de tela não podem ser exibidas. No entanto, as telas incluem:*

- Tela de listagem de alunos com um botão para adicionar novos alunos.
- Tela de cadastro/edição de aluno com campos para inserir dados e capturar foto.
- Tela de detalhes do aluno com opções para editar, deletar e visualizar pagamentos.
- Tela de listagem de pagamentos com opção para adicionar novos pagamentos.
- Tela de cadastro/edição de pagamento com campos para valor e data.

---

## 🚀 Tecnologias Utilizadas

- **Kotlin**: Linguagem principal do aplicativo.
- **Android Jetpack Components**:
  - **Room**: Persistência de dados locais.
  - **ViewModel**: Gerenciamento de dados relacionados à UI.
  - **LiveData**: Observabilidade dos dados.
  - **Data Binding**: Vinculação de dados aos layouts.
  - **Navigation Component**: Navegação entre fragments.
- **Arquitetura MVVM**: Para uma melhor organização do código.
- **RecyclerView**: Exibição eficiente de listas.
- **Material Design Components**: Para uma interface moderna e intuitiva.
- **Câmera**: Captura de fotos dos alunos.

---

## 🚚 Como Usar

### Cadastro de Aluno

#### Adicionar Novo Aluno:

- Na tela inicial, clique no botão **"+"**.
- Preencha os campos: **Nome**, **CPF**, **Telefone**.
- Marque se o aluno está **Ativo**.
- Selecione o **Tipo de Curso**: **Graduação** ou **Pós-Graduação**.
- Clique em **"Tirar Foto"** para capturar a foto do aluno.
- Clique em **"Salvar"**.

#### Editar Aluno:

- Na lista de alunos, clique no botão **"Editar"** ao lado do aluno desejado.
- Atualize as informações necessárias.
- Clique em **"Salvar"**.

#### Deletar Aluno:

- Na lista de alunos, clique no botão **"Deletar"** ao lado do aluno desejado.
- Confirme a exclusão.

### Listagem de Alunos

- Visualize todos os alunos cadastrados em uma lista.
- Cada item exibe o nome e a foto do aluno.
- Utilize os botões para **Editar**, **Deletar** ou **Ver Pagamentos**.

### Cadastro de Pagamento

#### Adicionar Novo Pagamento:

- Na lista de alunos, clique em **"Pagamentos"** ao lado do aluno desejado.
- Na tela de pagamentos, clique no botão **"+"**.
- Preencha o valor e selecione a data do pagamento.
- Clique em **"Salvar Pagamento"**.

#### Editar Pagamento:

- Na lista de pagamentos, clique em **"Editar"** ao lado do pagamento desejado.
- Atualize as informações necessárias.
- Clique em **"Salvar"**.

#### Deletar Pagamento:

- Na lista de pagamentos, clique em **"Deletar"** ao lado do pagamento desejado.
- Confirme a exclusão.

### Listagem de Pagamentos

- Visualize todos os pagamentos associados a um aluno específico.
- Cada item exibe o valor e a data do pagamento.
- Utilize os botões para **Editar** ou **Deletar** o pagamento.

---

## 📄 Licença

Este projeto está licenciado sob os termos da licença MIT. Consulte o arquivo [LICENSE](LICENSE) para obter mais informações.

