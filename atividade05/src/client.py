import requests

# URL base da API
BASE_URL = 'http://localhost:3000'

# funcao para listar todos os cursos
def listar_cursos():

    try:
        response = requests.get(f'{BASE_URL}/cursos')
        response.raise_for_status()

        cursos = response.json()

        if cursos:
            print('Lista de cursos:')
            for curso in cursos:
                print(curso)
        else:
            print('Nenhum curso cadastrado.')

    except Exception as e:
        print(f'Erro ao listar cursos: {e}')

# funcao para listar um curso específico por ID
def listar_curso_por_id(curso_id):
    try:
        response = requests.get(f'{BASE_URL}/cursos/{curso_id}')
        response.raise_for_status()
        
        print(f'Curso com ID {curso_id}:', response.json())

    except requests.exceptions.HTTPError as e:
        if response.status_code == 404:
            print(f'Curso com ID {curso_id} não encontrado.')
        else:
            print(f'Erro ao buscar curso: {e}')
   
    except Exception as e:
        print(f'Erro ao listar curso: {e}')

# funcao para criar um novo curso
def criar_curso(nome, carga_horaria):
    try:
        response = requests.post(f'{BASE_URL}/cursos', json={'nome': nome, 'carga_horaria': carga_horaria})
        response.raise_for_status()
        print('Curso criado com sucesso:', response.json())

    except requests.exceptions.HTTPError as e:
        print(f'Erro ao criar curso: {e}')

    except Exception as e:
        print(f'Erro ao criar curso: {e}')

# funcao para atualizar um curso existente
def atualizar_curso(curso_id, nome, carga_horaria):
    try:
        response = requests.put(f'{BASE_URL}/cursos/{curso_id}', json={'nome': nome, 'carga_horaria': carga_horaria})
        response.raise_for_status()
        print(f'Curso com ID {curso_id} atualizado com sucesso:', response.json())
    
    except requests.exceptions.HTTPError as e:
        if response.status_code == 404:
            print(f'Curso com ID {curso_id} não encontrado.')
        else:
            print(f'Erro ao atualizar curso: {e}')
    except Exception as e:
        print(f'Erro ao atualizar curso: {e}')

# funcao para deletar um curso existente
def deletar_curso(curso_id):
    try:
        response = requests.delete(f'{BASE_URL}/cursos/{curso_id}')
        response.raise_for_status()
        print(f'Curso com ID {curso_id} deletado com sucesso.')
    except requests.exceptions.HTTPError as e:
        if response.status_code == 404:
            print(f'Curso com ID {curso_id} não encontrado.')
        else:
            print(f'Erro ao deletar curso: {e}')
    except Exception as e:
        print(f'Erro ao deletar curso: {e}')


# Função para exibir o menu
def exibir_menu():
    print('\nEscolha uma operação:')
    print('1. Listar todos os cursos')
    print('2. Listar um curso por ID')
    print('3. Criar um novo curso')
    print('4. Atualizar um curso')
    print('5. Deletar um curso')
    print('6. Sair')

# funcao principal para interagir com o usuário
def main():
    while True:
        exibir_menu()
        escolha = input('Digite o número da operação: ')

        if escolha == '1':
            listar_cursos()
        elif escolha == '2':
            curso_id = input('Digite o ID do curso: ')
            listar_curso_por_id(curso_id)
        elif escolha == '3':
            nome = input('Digite o nome do curso: ')
            carga_horaria = input('Digite a carga horária do curso: ')
            criar_curso(nome, carga_horaria)
        elif escolha == '4':
            curso_id = input('Digite o ID do curso a ser atualizado: ')
            nome = input('Digite o novo nome do curso: ')
            carga_horaria = input('Digite a nova carga horária do curso: ')
            atualizar_curso(curso_id, nome, carga_horaria)
        elif escolha == '5':
            curso_id = input('Digite o ID do curso a ser deletado: ')
            deletar_curso(curso_id)
        elif escolha == '6':
            print('Saindo...')
            break
        else:
            print('Opção inválida. Tente novamente.')

# inicia o programa
if __name__ == '__main__':
    main()